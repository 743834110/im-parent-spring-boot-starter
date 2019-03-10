package xyz.berby.im.annotation;

import java.lang.annotation.*;

/**
 * @author LTF
 * 对传输有安全要求的方法则必须加上改注解
 * 以进行解密操作。
 * Created 2019/2/9
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrypt {


}
