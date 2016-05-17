package com.xupt.bookshop.model.order;

import com.xupt.bookshop.common.utils.DateTimeUtil;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.OrderState;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

/**
 * 返回前端对象
 * Created by zhangge on 16-5-5.
 */
public class OrdersVo {
    /**
     *订单号
     */
    String OrderId;
    /**
     * 联系人
     */
    String linkman;
    /**
     * 电话
     */
    String telphone;
    /**
     * 总金额
     */
    BigDecimal totalPrice;
    /**
     * 状态
     */
    OrderState status;
    /**
     * 下单时间
     */
    String orderTime;
    /**
     * 地址
     */
    String address;


    /**
     *商品名称
     */
    List<OrderItem> cartItems;

    public String getOrderId() {
        return OrderId;
    }

    public String getLinkman() {
        return linkman;
    }

    public String getTelphone() {
        return telphone;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OrderState getStatus() {
        return status;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getAddress() {
        return address;
    }



    public List<OrderItem> getCartItems() {
        return cartItems;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    public void setOrderTime(DateTime orderTime) {
        this.orderTime = DateTimeUtil.getStandardStr(orderTime);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCartItems(List<OrderItem> cartItems) {
        this.cartItems = cartItems;
    }
}
