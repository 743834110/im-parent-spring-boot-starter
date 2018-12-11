package xyz.berby.im.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.berby.im.annotation.Validate;
import xyz.berby.im.entity.User;

/**
 * 权限控制切面
 * 不使用切面进行权限的检查
 * 因为在本系统中在方法调用前已经
 * 使用大量的反射用于进行方法入参的数据填充了
 * <p>
 * 权限检查基本原理：
 *
 * @author li
 */
@Slf4j
@Component
@Aspect
public class AuthAspect {


    @Pointcut(value = "@annotation(validate)", argNames = "validate")
    public void serve(Validate validate) {

    }

    /**
     * <pre>
     * 由于切入点的限制，本系统的权限检查所用到的权限
     * 参数(user)必要要置于所有参数前或者所有的参数后
     * </pre>
     *
     * @param joinPoint 接入点
     * @param validate  标注有访问权限的注解
     * @param user      权限实例
     * @return
     */
    @Before(value = "serve(validate) && (args(user,..) || args(..,user))", argNames = "joinPoint, validate, user")
    public boolean authValidate(JoinPoint joinPoint, Validate validate, User user) {
        
        return true;
    }
}
