package xyz.berby.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import xyz.berby.im.annotation.Authorization;
import xyz.berby.im.annotation.Decrypt;
import xyz.berby.im.aspect.AuthAspect;
import xyz.berby.im.constant.Constant;
import xyz.berby.im.entity.AbstractUser;
import xyz.berby.im.exception.HttpException;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.security.Security;
import xyz.berby.im.util.AopTargetUtil;
import xyz.berby.im.util.ApplicationContextHolder;
import xyz.berby.im.util.ReflectUtil;
import xyz.berby.im.vo.RespBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 抽象控制类
 * 用于控制层的封装
 */
public abstract class AbstractRestfulController {

    @Autowired
    private AuthAspect authAspect;

    @Autowired
    private DefaultSettingProperty defaultSetting;

    @Autowired
    private Security security;

    /**
     * 路径到方法的映射
     */
    private final static Map<String, Method> PATH_METHOD_MAPPING = new TreeMap<>();

    /**
     *  通用处理方法
     *  response.addHeader("Access-Control-Allow-Origin", "*");
     *  response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
     *  response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
     *  response.addHeader("Access-Control-Max-Age", "1800");//30 min
     * @param serviceName 服务名
     * @param operateName 操作
     * @param request 请求对象
     * @param response 响应对象
     * @return
     */
    public Object getCommandDeal(String serviceName, String operateName
            , HttpServletRequest request
            , HttpServletResponse response
            , String string, MultipartFile[] files) throws Exception {

        // 解决跨域sessionId问题

        // 明确请求端：admin|app|web|plain(即是统一处理所有端的请求)
        String requestHeader = request.getHeader("user-agent");

        Object service = null;
        try {
            service = ApplicationContextHolder.getBean(serviceName);
        } catch (Exception e){}

        if (service == null) {
            return new RespBody("service: " + serviceName + " not found!", response);
        }

        // 各种switch

        // 直接查找服务方法并运行
        String path = serviceName + ":" + operateName;
        Method method = PATH_METHOD_MAPPING.get(path);
        method = method == null? ReflectUtil.getMethod(service, operateName): method;
        if (method == null) {
            return new RespBody( serviceName + "." + operateName + "() not found!", response);
        }
        // 缓存，保证性能
        PATH_METHOD_MAPPING.put(path, method);

        Map<String, String[]> params = request.getParameterMap();


        Object data = null;
        try {
            // 开始反射到服务类的方法
            // 穿透代理对象
            Method actualMethod = null;
            Object actualObject = AopTargetUtil.getTarget(service);
            if (actualObject.equals(service)) {
                actualMethod = method;
            }
            else {
                actualMethod = actualObject.getClass().getMethod(operateName, method.getParameterTypes());
            }
            // 暂时假设user实体接入
            AbstractUser user = null;
            // 检查信息是否需要进行解密操作
            String securityMode = this.defaultSetting.getSecurityMode();
            if (actualMethod.isAnnotationPresent(Decrypt.class)) {
                string = this.security.decryptMessage(string);
            }

            // 处理消息体提交的数据
            Map<String, String[]> stringMap = null;
            if (string != null) {
                stringMap = this.handleString(string);
            }
            else {
                stringMap = new HashMap<>();
            }
            if (stringMap != null) {
                for (Map.Entry<String, String[]> entry : params.entrySet()) {
                    stringMap.put(entry.getKey(), entry.getValue());
                }
            }

            Object[] paramValues = ReflectUtil.getParamValues(stringMap, actualMethod, files, user);

            if (paramValues == null) {
                data = method.invoke(service);
            }
            else {
                data = method.invoke(service, paramValues);
            }

            // 按照约定高于配置的原则，如果方法名为login时session则将保存该运行结果
            // logout则消除数据
            String sessionId;
            HttpSession session = request.getSession();
            switch (operateName) {
                case Constant.LOGIN_METHOD_NAME:
                    sessionId = session.getId();
                    session.setAttribute(sessionId, data);
                    break;
                case Constant.LOGOUT_METHOD_NAME:
                    sessionId = session.getId();
                    session.removeAttribute(sessionId);
                    break;
                default:
            }

        } catch (HttpException e) {

            return new RespBody(e.getStatus(), e.getMessage(), response);

        } catch (Exception e) {
            String message = e.getCause().getMessage();
            if (message == null || message.equals("")) {
                message = "运行时参数异常";
            }
            e.printStackTrace();
            return new RespBody(500, message, response);
        }


        return new RespBody(data, response);
    }

    /**
     * <pre>
     * 解析自定义的数据解析格式
     * 当前定义的解析格式为:
     * {
     *     某方法参数名：{
     *         参数类内部的数据的键值对表现方式
     *     }
     * }
     * 如服务queryOrgService.queryList(ReqBody<ServerConfig> reqBody);
     * string的格式应为
     * {
     *     reqBody: {
     *         param: {
     *             ...
     *         },
     *         serverConfig: {
     *             ...
     *         }
     *         ...
     *     }
     *     ...
     * }
     * 转换后的map数据应为
     * key => reqBody
     * value => {
     *     param: {
     *         ...
     *     },
     *     serverConfig: {
     *         ...
     *     }
     *     ...
     * }
     * 一个方法中有多个对象也类似编排即可
     * 不过要注意的是，如果post消息体post提交中带有相同的key值，那么post提交的数据将会
     * 覆盖post消息体的消息
     * </pre>
     * @param string 未解析的数据
     * @return map
     */
    abstract Map<String, String[]> handleString(String string);



    /**
     * 权限检查
     *
     * @return 返回true表示用户拥有该权限或者该方法不需要进行权限的检查
     */
    private boolean checkAuth(Method method, AbstractUser user) {
        Annotation annotation = method.getAnnotation(Authorization.class);
        if (annotation != null) {
            return this.authAspect.isAllow( (Authorization) annotation, user);
        }

        return true;
    }


}
