package xyz.berby.im.aspect;

import cn.hutool.core.bean.BeanUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.berby.im.annotation.DefaultValue;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LTF
 * Created on 2019/4/4
 * 默认值注入切面
 */
@Aspect
@Component
public class DefaultValueAspect {

    /**
     * 正则匹配对象
     */
    private Pattern pattern;

    @Autowired
    private HttpSession httpSession;

    public DefaultValueAspect() {
        this.pattern  = Pattern.compile("(\\d)\\.(\\w+)=(\\w+)\\.?(\\w+)?");
    }

    @Pointcut(value = "@annotation(defaultValue)")
    public void defaultValueAspect(DefaultValue defaultValue) {
    }

    /**
     * 进行开始进行默认参数的注入
     * @param joinPoint
     * @param defaultValue
     */
    @Before(value = "defaultValueAspect(defaultValue)", argNames = "joinPoint, defaultValue")
    public void valueInject(JoinPoint joinPoint, DefaultValue defaultValue) {
        Object[] args = joinPoint.getArgs();
        String expression = defaultValue.expression();
        String[] strings = expression.split(",");
        for (String string : strings) {
            Matcher matcher = this.pattern.matcher(string);
            // 没找到或者不是四个匹配的掉过本次循环
            if (!matcher.find() || matcher.groupCount() != 4) {
                continue;
            }
            int index = Integer.parseInt(matcher.group(1));
            String targetPropertyName = matcher.group(2);
            String sourceName = matcher.group(3);
            String sourcePropertyName = matcher.group(4);
            // 当第四为null,而且第三个值为now,将注入日期类型
            if (sourcePropertyName == null) {
                if (sourceName.equals("now")) {
                    BeanUtil.setFieldValue(args[index], targetPropertyName, new Date());
                }
                continue;
            }
            Object sourceObject = this.httpSession.getAttribute(sourceName);
            // session当中不存在对应的属性值，也将返回
            if (sourceObject == null) {
                continue;
            }
            Object sourceFieldValue = BeanUtil.getFieldValue(sourceObject, sourcePropertyName);
            BeanUtil.setFieldValue(args[index], targetPropertyName, sourceFieldValue);
        }

    }
}
