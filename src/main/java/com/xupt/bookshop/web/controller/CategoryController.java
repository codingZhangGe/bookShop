package com.xupt.bookshop.web.controller;

import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.SessionUtil;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.category.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;
    Logger logger= LoggerFactory.getLogger(CategoryController.class);

    @RequestMapping("/")
    @JsonBody
    public Object categoryDetail(HttpServletRequest request) throws ParameterException {
        String login = CookieUtil.getCookieValue(request, "login_id");
        List<CartItem> cartItem = categoryService.categoryDetail(login);
        if(null== cartItem){
            return  JsonResult.fail("加入购物车失败");
        }
        return JsonResult.succ(cartItem);
    }

   @RequestMapping("/deleteCart")
    public Object deleteCartItem(@RequestParam("bookId") String bookId)
    {
        logger.info("<deleteCategoryItem>  bookid={}  username={}",bookId, SessionUtil.getUserSession().getName());
        Preconditions.checkNotNull(bookId!=null,"商品id 不存在");
        ResultOfRequest resultOfRequest = categoryService.deleteCartItem(bookId);

        return resultOfRequest;
    }

}
