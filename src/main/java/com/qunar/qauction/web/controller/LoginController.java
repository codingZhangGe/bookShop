package com.qunar.qauction.web.controller;

import com.qunar.qauction.common.utils.CookieUtil;
import com.qunar.qauction.common.utils.SHA1;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import qunar.web.security.LoginManager;
import qunar.web.security.QssoClient;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Description: Login
 *
 * @author lingtong.fu
 * @version 2016-04-18 13:02
 */

@Controller
public class LoginController {

    @Resource
    private LoginManager<String> loginManager;

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "token", required = false) String token, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        if (StringUtils.isEmpty(token)) {
            return new ModelAndView("login", "message", "token不能为空");
        }

        String loginId = QssoClient.verityLoginToken(token);
        if (StringUtils.isEmpty(loginId)) {
            return new ModelAndView("login", "message", "token无效");
        }

        if (loginManager.isLogin(request)) {
            return new ModelAndView("redirect:/hello.htm");
        }

        loginManager.login(loginId, response);

        CookieUtil.addCookie(response, "encrypt", SHA1.hexSha1(loginId));

        return new ModelAndView("redirect:/hello.htm");
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginManager.logout(response);
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
