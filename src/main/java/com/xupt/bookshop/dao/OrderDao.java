package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.Orders;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
@Repository
public interface OrderDao {
    public void createOrders(@Param("order")Orders orders);
    public void createOrderItem(@Param("orderItem") Orders orders);

    public List<OrderItem> queryOrderItem(@Param("orderId") String orderId);
    public List<Orders> queryOrderDetails(RowBounds rowBounds,@Param("username")String username);
    public List<Orders> queryOrderByState(RowBounds rowBounds,@Param("username")String username,@Param("state")int orderState);

    public int updateOrderStatus(@Param("orderState")OrderState orderState);

    public void insertTotalPrice(@Param("totalPrice")BigDecimal totalPrice);
    public List<String> selectOrderItemWithTime(@Param("now")DateTime now,@Param("state")OrderState orderState);
    public int queryOrderPagesWithState(@Param("username") String username,@Param("state")int state);
    public int queryOrderPages(@Param("username") String username);


}
