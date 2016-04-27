package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**购物车页面
 * Created by zhangge on 16-4-26.
 */
@Controller("/Category")
public class CategoryController {

    @Resource
    CategoryService categoryService;



    @RequestMapping("/")
    @JsonBody
    public Object categoryDetail(HttpServletRequest request) throws ParameterException {
        CookieUtil.getCookieValue(request,"login_id");
        categoryService.
    }

    //TODO 从购物车下单，添加订单数据到数据库
    public Object addOrderItem(@RequestParam("categoryId") String categoryId,){
       return null;
    }

    //TODO 删除购物车信息
}
