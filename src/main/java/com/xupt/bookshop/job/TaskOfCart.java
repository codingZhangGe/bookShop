package com.xupt.bookshop.job;

import com.xupt.bookshop.service.orderService.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务扫描订单表,如果生单时间距离当前时过于10 个小时则改变为取消状态
 * Created by zhangge on 16-4-27.
 */
@Component
public class TaskOfCart {

    Logger logger= LoggerFactory.getLogger(TaskOfCart.class);
    @Resource
    OrderService orderService;
 //   @Scheduled(cron = "0/5 * * * * ?") //5秒执行一次
    public  void doTask(){
      logger.info("<TaskOfCart> doing");
        List<String> orderItems=orderService.selectOrderitemWithTime();
       //配置为下线
        updateOrderState(orderItems);
    }

    public void  updateOrderState(List<String> orderList){

        for(String orderId:orderList) {
            orderService.updateOrderStatus(orderId);
        }


    }


}
