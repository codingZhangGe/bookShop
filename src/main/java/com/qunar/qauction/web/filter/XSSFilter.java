package com.qunar.qauction.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Description: XSS转义过滤器过滤器
 *
 * @author lingtong.fu
 * @version 2016-04-18 15:40
 */
public class XSSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest tropeRequest = new XSSRequestWrapper((HttpServletRequest) request);
        filterChain.doFilter(tropeRequest, response);
    }

    @Override
    public void destroy() {

    }
}
