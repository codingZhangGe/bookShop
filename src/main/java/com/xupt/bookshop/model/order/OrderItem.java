package com.xupt.bookshop.model.order;

import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.OrderState;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

/**订单详情
 * Created by zhangge on 16-4-27.
 */
public class OrderItem {
    /**
     *订单号
     */
    String OrderId;
    /**
     * 下单用户
     */
    String username;
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
    DateTime orderTime;
    /**
     * 地址
     */
    String address;

    /**
     *商品名称
     */
    List<CartItem> cartItems;


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

    public DateTime getOrderTime() {
        return orderTime;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CartItem> getCartItems() {
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
        this.orderTime = orderTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
