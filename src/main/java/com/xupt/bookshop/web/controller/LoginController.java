package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.ParameterCheckUtil;
import com.xupt.bookshop.common.utils.SHA1;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.login.User;
import com.xupt.bookshop.model.login.param.LoginPara;
import com.xupt.bookshop.service.category.CategoryService;
import com.xupt.bookshop.service.login.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import qunar.web.security.LoginManager;
import qunar.web.security.QssoClient;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Description: Login
 *
 * @author ge.zhang
 * @version 2016-04-18 13:02
 */

@Controller
@RequestMapping("/xupt")
public class LoginController {

    @Resource
    LoginService loginService;
    @Resource
    CategoryService categoryService;

    /**
     * 登陆
     *index.jsp
     * @param httpServletRequest
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object UserLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ,@Valid LoginPara loginPara, BindingResult result) {

        if (ParameterCheckUtil.checkBingResultParam(result).equals("true")) {
            User user = loginService.queryByName(loginPara.getUsername());

            if (user != null) {
                if(!loginPara.getPassword().equals(user.getPassword())){
                    return  JsonResult.fail("密码输入错误");
                }
                else{
                    CookieUtil.addCookie(httpServletResponse,"login_id",loginPara.getUsername(),60);
                    //用户登陆创建购物车
                    categoryService.createCategoryWithUser(loginPara.getUsername());
                    return JsonResult.succ();
                }
            } else {
                return JsonResult.fail("用户不存在");
            }
        } else
            return JsonResult.fail(ParameterCheckUtil.checkBingResultParam(result));
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        return "redirect:/login";
    }



    //todo 用户注册功能
}
