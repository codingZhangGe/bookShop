package com.xupt.bookshop.web.controller;

import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.SessionUtil;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.cart.CartItemVo;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.cart.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**购物车页面
 * Created by zhangge on 16-4-26.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Resource
    CartService cartService;
    Logger logger= LoggerFactory.getLogger(CartController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public Object cartDetail(HttpServletRequest request) throws ParameterException, UnsupportedEncodingException {
        String login = CookieUtil.getCookieValue(request, "login_id");

        CartItemVo cartItem = cartService.categoryDetail(login);
        if(null== cartItem){
            return  JsonResult.fail("购物车不存在");
        }
        return JsonResult.succ(cartItem);
    }

   @RequestMapping("/deleteCartItem")
   @ResponseBody
    public Object deleteCartItem(@RequestParam("bookId") List<String> bookId)
    {
        logger.info("<deleteCategoryItem>  bookid={}  username={}",bookId, SessionUtil.getUserSession().getName());
        Preconditions.checkNotNull(bookId!=null,"商品id 不存在");
        ResultOfRequest resultOfRequest = cartService.deleteCartItem(bookId);

        return resultOfRequest;
    }

}
