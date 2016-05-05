package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.order.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
@Repository
public interface OrderDao {
    public void createOrders(@Param("order")OrderItem orderItem);
    public void createOrderItem(@Param("orderItem") OrderItem orderItem);

    public OrderItem queryOrderDetails(String username);

    public int updateOrderStatus(@Param("orderState")OrderState orderState);


    public List<String> selectOrderItemWithTime(@Param("now")DateTime now,@Param("state")OrderState orderState);
}
