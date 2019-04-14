package xyz.berby.im.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LTF
 * Created on 2019/4/12
 *
 */
@Slf4j
public class IpUtil {

    /**
     * 获取本机的ip访问地址和端口
     * @return
     */
    public static String getServerIpAddress() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String addr = request.getLocalAddr();
        int port = request.getLocalPort();
        String schema = request.getScheme();
        String contextPath = request.getContextPath();
        String path = request.getSession().getServletContext().getRealPath("/");
        log.info("current real path:" + path);
        return schema + "://" + addr + ":" + port + "/" + ("".equals(contextPath)? "": contextPath + "/");
    }
}
