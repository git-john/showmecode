package com.john.showmecode.logback;

import com.john.showmecode.logback.util.TraceUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: kangq
 * @Date: 2019/7/5 10:15
 */
public class LoggerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            TraceUtil.traceStart();

            filterChain.doFilter(request, response);
        } finally {
            TraceUtil.traceEnd();
        }
    }
}
