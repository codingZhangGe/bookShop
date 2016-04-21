package com.qunar.qauction.common.utils;

import com.qunar.qauction.common.exceptions.ParameterException;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class CookieUtil {
    /**
     * 删除cookie
     */
    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 增加cookie
     */
    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 根据cookie名获取cookie值
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) throws ParameterException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            ParameterCheckUtil.checkNotNull(cookieName, "cookie名不能为空");
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return StringUtils.isBlank(cookie.getValue()) ? null : cookie.getValue();
                }
            }
        }
        return null;
    }

}
