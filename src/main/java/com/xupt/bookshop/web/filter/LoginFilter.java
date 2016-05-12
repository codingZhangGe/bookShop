package com.xupt.bookshop.web.filter;

import com.google.common.base.Strings;
import com.xupt.bookshop.common.Monitor;
import com.xupt.bookshop.common.utils.SessionUtil;
import com.xupt.bookshop.dao.LoginDao;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.URIDereferencer;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Description: Login
 *
 * @author ge.zhang
 * @version 2016-04-18 15:40
 */

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        Monitor.HTTP_REQUEST_COUNT.inc();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //如果现在处在登陆界面

        if (httpServletRequest.getServletPath().contains("login")||httpServletRequest.getServletPath().contains("register")) {
            filterChain.doFilter(request, response);
            return;
        }

        //是否有cookies
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            httpServletResponse.sendRedirect("/login.html");
            return;
        }


        String username = null;
        //cookie 中存在内容获取到对应的值
        for (Cookie cookie : cookies) {
            if ("login_id".equals(cookie.getName())) {
                username = URLDecoder.decode( cookie.getValue(),"utf-8");
                break;
            }
        }
        if (Strings.isNullOrEmpty(username)) {
            httpServletResponse.sendRedirect("login.html");
        }

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(
                (httpServletRequest).getSession().getServletContext());
        LoginDao loginDao = webApplicationContext.getBean(LoginDao.class);
        SessionUtil.setUserSession(loginDao.queryByName(username));
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        SessionUtil.closeSession();
    }

    @Override
    public void destroy() {
    }

}
