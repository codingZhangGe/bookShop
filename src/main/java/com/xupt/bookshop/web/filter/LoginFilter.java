package com.xupt.bookshop.web.filter;

import com.xupt.bookshop.common.Monitor;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.LogUtils;
import com.xupt.bookshop.common.utils.SHA1;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: Login
 *
 * @author lingtong.fu
 * @version 2016-04-18 15:40
 */

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Monitor.HTTP_REQUEST_COUNT.inc();
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        String path = servletRequest.getServletPath();
        // 登陆页 静态资源无需过滤
        if (path.endsWith("/login") || path.contains(".htm") || path.startsWith("/js/") || path.startsWith("/css")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        try {
            String login_id = CookieUtil.getCookieValue(servletRequest, "login_id");
            if (login_id == null || "".equals(login_id)
                    || !SHA1.hexSha1(login_id).equals(CookieUtil.getCookieValue(servletRequest, "encrypt"))) {
                servletResponse.sendRedirect("/login");
            } else {
                chain.doFilter(request, response);
            }
        } catch (ParameterException e) {
            LogUtils.info("{}{}", e.getMessage(), e);
        }
    }

    @Override
    public void destroy() {
    }

}
