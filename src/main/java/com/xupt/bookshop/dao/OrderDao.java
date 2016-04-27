package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.enums.State;
import com.xupt.bookshop.model.order.OrderItem;

/**
 * Created by zhangge on 16-4-27.
 */
public interface OrderDao {
    //TODO SQL语句 插入订单数据
    public void createOrder(OrderItem orderItem);

    //TODO SQL语句
    public OrderItem queryOrderDetails();
    //TODO sql 语句
    public int updateOrderStatus(State state);
}
