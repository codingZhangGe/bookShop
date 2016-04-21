package com.qunar.qauction.web.interceptor;

import com.google.common.base.Strings;
import com.qunar.qauction.common.Constants;
import com.qunar.qauction.common.utils.CookieUtil;
import com.qunar.qauction.model.admin.Administrator;
import com.qunar.qauction.service.admin.AdministratorService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
public class AdminAuthorityInterceptor implements HandlerInterceptor {

    @Resource
    private AdministratorService administratorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String qtalk = CookieUtil.getCookieValue(request, Constants.QTALK);
        if (Strings.isNullOrEmpty(qtalk)) {
            response.sendRedirect("/administrator/noAuthority");
            return false;
        }
        Administrator administrator = administratorService.selectAdminByQtalk(qtalk);
        if (null == administrator) {
            response.sendRedirect("/administrator/noAuthority");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
