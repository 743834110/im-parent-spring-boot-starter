package xyz.berby.im.annotation;

import java.lang.annotation.*;

/**
 * token认证
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenValidate {

    /**
     * 当注解到类中有效，
     * 该值表示忽略token检查的方法名
     * @return
     */
    String[] ignores() default {};
}
