package xyz.berby.im.annotation;

import java.lang.annotation.*;

/**
 *
 * 自定义权限认证注解
 * @author litianfeng
 *
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {


    /**
     * 权限字符串
     * @return
     */
    String value();

    /**
     * 角色字符串
     * @return
     */
    String role() default "";
}
