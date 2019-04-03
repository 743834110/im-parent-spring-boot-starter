package xyz.berby.im.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.berby.im.property.DefaultSettingProperty;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 允许跨域过滤器
 *
 * @author LTF
 * Created on 2019/4/3
 */
@Component
public class CrossOriginsFilter implements Filter {

    @Autowired
    private DefaultSettingProperty property;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.addHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");
        httpServletResponse.addHeader("Access-Control-Max-Age", "1800");//30 min
        //若要返回cookie、携带session等信息则将此项设置我true
        httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
