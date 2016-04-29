package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.order.OrderItem;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
@Repository
public interface OrderDao {
    public void createOrder(OrderItem orderItem);

    public OrderItem queryOrderDetails(String username);

    public int updateOrderStatus(BookState bookState);


    public List<String> selectOrderItemWithTime(DateTime now,OrderState state);
}
