package xyz.berby.im.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import xyz.berby.im.annotation.Validate;
import xyz.berby.im.entity.AbstractAuth;
import xyz.berby.im.entity.AbstractRole;
import xyz.berby.im.entity.AbstractUser;

import java.util.List;

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
     * 暂不进行权限判断结果的缓存
     * </pre>
     *
     * @param joinPoint 接入点
     * @param validate  标注有访问权限的注解
     * @param user      权限实例
     * @return
     */
    @Around(value = "serve(validate) && (args(user,..) || args(..,user))", argNames = "joinPoint, validate, user")
    private Object authValidate(ProceedingJoinPoint joinPoint, Validate validate, AbstractUser user) throws Throwable {
        boolean allowed = this.isAllow(validate, user);
        Object object = null;
        if (allowed) {
            object = joinPoint.proceed(joinPoint.getArgs());
        }
        return object;
    }

    public boolean isAllow(Validate validate, AbstractUser<AbstractAuth, AbstractRole> user) {
        if (user == null) {
            return false;
        }
        // 检查角色, role名称不为空字符串时
        String role = validate.role();
        List<AbstractRole> orgRoleList = user.getRoleList();
        if (!role.equals("") && orgRoleList != null) {
            for (AbstractRole orgRole : user.getRoleList()) {
                if (role.equals(orgRole.getRoleName()))
                    return true;
            }
        }

        // 检查权限
        String authName = validate.value();
        List<AbstractAuth> authList = user.getAuthList();
        if (authList != null) {
            for (AbstractAuth auth : user.getAuthList()) {
                if (authName.equals(auth.getAuthName())) {
                    return true;
                }
            }
        }

        return true;
    }
}
