package xyz.berby.im.annotation;

/**
 * @author LTF
 * 根据表达式进行参数值的再次注入
 * Created on 2019/4/3
 */
public @interface ConditionalDefaultValue {

    /**
     * 表达式
     */
    String expression() default "";


}
