package xyz.berby.im.util;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;

public class AopTargetUtil {

    private final static Map<Object, Object> OBJECT_MAP = new WeakHashMap<>();

    /**
     * 获取 目标对象
     *
     * @param proxy 代理对象
     * @return
     * @throws Exception
     */
    public static Object getTarget(Object proxy) throws Exception {

        if (!AopUtils.isAopProxy(proxy)) {
            //不是代理对象
            return proxy;
        }
        Object target = OBJECT_MAP.get(proxy);
        if (target != null)
            return target;

        if (AopUtils.isJdkDynamicProxy(proxy)) {
            target = getJdkDynamicProxyTargetObject(proxy);
        } else {
            //cglib
            target = getCglibProxyTargetObject(proxy);
        }
        OBJECT_MAP.put(proxy, target);
        return target;
    }


    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
        return target;
    }


    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
        return target;
    }

}
