package com.xupt.bookshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**购物车页面
 * Created by zhangge on 16-4-26.
 */
@Controller("/Category")
public class CategoryController {

    //TODO 从购物车下单，添加订单数据到数据库
    public Object addOrderItem(@RequestParam("categoryId") String categoryId,)

    //TODO 删除购物车信息
}
