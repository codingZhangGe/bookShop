package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //TODO 删除购物车信息

}
