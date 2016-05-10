package com.xupt.bookshop.web.controller;

import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.SessionUtil;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.cart.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/")
    @JsonBody
    public Object cartDetail(HttpServletRequest request) throws ParameterException {
        String login = CookieUtil.getCookieValue(request, "login_id");
        List<CartItem> cartItem = cartService.categoryDetail(login);
        if(null== cartItem){
            return  JsonResult.fail("加入购物车失败");
        }
        return JsonResult.succ(cartItem);
    }

   @RequestMapping("/deleteCartItem")
   @JsonBody
    public Object deleteCartItem(@RequestParam("bookId") List<String> bookId)
    {
        logger.info("<deleteCategoryItem>  bookid={}  username={}",bookId, SessionUtil.getUserSession().getName());
        Preconditions.checkNotNull(bookId!=null,"商品id 不存在");
        ResultOfRequest resultOfRequest = cartService.deleteCartItem(bookId);

        return resultOfRequest;
    }

}
