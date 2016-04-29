package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.param.OrderParam;
import com.xupt.bookshop.service.orderService.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**下单操作
 * Created by zhangge on 16-4-27.
 */
@Controller
@RequestMapping("/Order")
public class OrderController {

    @Resource
    OrderService orderService;


    /**
     * 生成订单,并且返回订单详情.
     * @param categoryId
     * @param orderParam
     * @return
     */
    @RequestMapping("/doOrder")
    @ResponseBody
    public JsonResult doorderAndDetail(@RequestParam("categoryId") String categoryId,@Valid OrderParam orderParam,
                                       @CookieValue("login_id") String usrname){
        //TODO 检测
        ResultOfRequest orderItem = orderService.createOrder(usrname, orderParam);
          return JsonResult.succ(orderItem);
      }


    //TODO  更改订单状态(权限)
   public JsonResult updateOrderStatus(@RequestParam("categoryId") String categoryId){
 return null;
   }
    //TODO  删除订单(权限)
    //TODO  修改订单(权限) 表示已经下单成功的订单
}
