package com.xupt.bookshop.web.controller;

import com.google.common.base.Preconditions;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.param.OrderParam;
import com.xupt.bookshop.service.orderService.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger= LoggerFactory.getLogger(OrderController.class);

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
        logger.info("<doorderAndDetail>  create order user={}",usrname);
        Preconditions.checkArgument(categoryId!=null,"购物车不存在");
        ResultOfRequest orderItem = orderService.createOrder(usrname, orderParam);
          return JsonResult.succ(orderItem);
      }

    }
