package cn.gzsxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @WebFilter 注解表示这是一个Filter 拦截器
 *
 * filterName :  拦截器的名称
 *
 * urlPatterns : 拦截器的路径
 *
 */
//@WebFilter(filterName = "bootFilter",urlPatterns = "/boot.do")
public class BootFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截了 BootFilter 进入");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("拦截了 BootFilter 退出");
    }

    @Override
    public void destroy() {

    }
}
