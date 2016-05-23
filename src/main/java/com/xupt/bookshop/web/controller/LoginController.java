package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.ParameterCheckUtil;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.login.User;
import com.xupt.bookshop.model.login.param.LoginPara;
import com.xupt.bookshop.model.login.param.RegisterParam;
import com.xupt.bookshop.service.cart.CartService;
import com.xupt.bookshop.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Description: Login
 *
 * @author ge.zhang
 * @version 2016-04-18 13:02
 */

@Controller
@RequestMapping("/xupt")
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(LoginController.class);
    @Resource
    LoginService loginService;
    @Resource
    CartService cartService;
    @Resource
    CartDao cartDao;


    /**
     * 登陆
     *index.jsp
     * @param httpServletRequest
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object UserLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ,@Valid LoginPara loginPara, BindingResult result) throws UnsupportedEncodingException {

        if (ParameterCheckUtil.checkBingResultParam(result).equals("true")) {
            User user;
            user = loginService.queryByName(loginPara.getUsername());

            if (user != null) {
                if(!loginPara.getPassword().equals(user.getPassword())){
                    return  JsonResult.fail("密码输入错误");
                }
                else{
                    String username= URLEncoder.encode(loginPara.getUsername(),"utf-8");
                    CookieUtil.addCookie(httpServletResponse,"login_id",username,60);
                    //用户登陆创建购物车
                    cartService.createCategoryWithUser(loginPara.getUsername());
                    return JsonResult.succ();
                }
            } else {
                return JsonResult.fail("用户不存在");
            }
        } else
            return JsonResult.fail(ParameterCheckUtil.checkBingResultParam(result));
    }

    /**
     * 退出登陆
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //清除cookie 清除购物车
        try {
            cartDao.removeCartItem(CookieUtil.getCookieValue(request,"login_id"));
            CookieUtil.deleteCookie(response,"login_id");
        } catch (ParameterException e) {
            logger.error("<LoginController>  logout get cookie exception {}",e);
        }

        return "redirect:/login";
    }

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
     public Object register(@Valid RegisterParam registerParam){

         return  JsonResult.succ( loginService.createUser(registerParam));
     }


}
