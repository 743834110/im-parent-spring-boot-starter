package xyz.berby.im.annotation;

import java.lang.annotation.*;

/**
 * @author LTF
 * 根据表达式进行参数值的再次注入
 * Created on 2019/4/3
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {

    /**
     * 表达式
     * eg: 0.userId=user.userId
     * 0表示参数位置
     * 点号后面代表该实体属性
     * 等号右边第一个单词代表的实体来自于以“user”命名的session的attributes当中，
     * 其为空时不报错，即是不进行参数的默认注入
     */
    String expression() default "";


}
