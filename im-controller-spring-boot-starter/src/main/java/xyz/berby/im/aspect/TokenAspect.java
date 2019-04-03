package xyz.berby.im.aspect;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.AbstractController;
import xyz.berby.im.annotation.TokenValidate;
import xyz.berby.im.controller.AbstractRestfulController;
import xyz.berby.im.controller.RestfulController;
import xyz.berby.im.entity.AbstractUser;
import xyz.berby.im.exception.HttpException;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.util.ApplicationContextHolder;
import xyz.berby.im.util.JwtUtil;
import xyz.berby.im.vo.AccessToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Aspect
@Lazy
@Component
public class TokenAspect {

    @Autowired
    private DefaultSettingProperty property;

    @Autowired
    private AbstractRestfulController controller;

    @Pointcut(value = "@annotation(tokenValidate)", argNames = "tokenValidate")
    public void tokenAspect(TokenValidate tokenValidate) {

    }

    @Before(value = "tokenAspect(tokenValidate)", argNames = "joinPoint, tokenValidate")
    public void validate(JoinPoint joinPoint, TokenValidate tokenValidate) throws Exception {

        HttpServletRequest request = ApplicationContextHolder.getRequest();
        HttpSession session = request.getSession();
        AbstractUser user = (AbstractUser) session.getAttribute(session.getId());
        // 当user为空时才进行token的检查
        if (user != null) {
            return;
        }
        Class clazz = tokenValidate.annotationType();
        // 判断是不是类注解
        boolean isTypeAnnotation = joinPoint.getTarget().getClass().isAnnotationPresent(TokenValidate.class);
        boolean check = !isTypeAnnotation;
        if (isTypeAnnotation && !ArrayUtil.contains(tokenValidate.ignores(), joinPoint.getSignature().getName())) {
            check = true;
        }
        if (check) {
            String token = request.getHeader("token");
            Map<String, Object> setting = this.property.getSetting();
            String accessTokenJson = JwtUtil.validateJWT(token, (String) setting.get(DefaultSettingProperty.PRIVATE_KEY));
            if (accessTokenJson == null)
                throw new  HttpException("账户尚未登录，禁止访问", 401);
            // 获取信息，进行登录操作,成功时将继续向下访问
            this.controller.getCommandDeal((String)setting.get(DefaultSettingProperty.LOGIN_SERVICE_NAME),
                    (String)setting.get(DefaultSettingProperty.LOGIN_SERVICE_METHOD),
                    request,
                    null,
                    accessTokenJson,
                    null
                    );
        }

    }



}
