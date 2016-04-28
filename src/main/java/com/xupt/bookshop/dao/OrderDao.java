package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.order.OrderItem;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
public interface OrderDao {
    //TODO SQL语句 插入订单数据
    public void createOrder(OrderItem orderItem);

    //TODO SQL语句
    public OrderItem queryOrderDetails();
    //TODO sql 语句
    public int updateOrderStatus(BookState bookState);

    //TODO sql 语句
    public List<String> selectOrderItemWithTime(DateTime now,OrderState state);
}
