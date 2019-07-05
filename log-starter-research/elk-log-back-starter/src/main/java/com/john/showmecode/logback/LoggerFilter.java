package com.john.showmecode.logback;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: kangq
 * @Date: 2019/7/5 10:15
 */
public class LoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(httpServletRequest);
        filterChain.doFilter(myRequestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
