package com.xupt.bookshop.service.orderService;

import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.param.OrderParam;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */

public interface OrderService {

    //创建订单
    ResultOfRequest createOrder(String username,OrderParam orderParam);
    List<OrderItem> queryOrderWithUser(int currentPage,int pageSize,String username);
   // 更新订单状态 只存在时间到了修改成为失效
    int updateOrderStatus(String OrderId);
     List<String> selectOrderitemWithTime();


}
