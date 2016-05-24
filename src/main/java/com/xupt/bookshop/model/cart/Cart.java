package com.xupt.bookshop.model.cart;

import java.math.BigDecimal;

/**购物车类
 * Created by zhangge on 16-4-30.
 */
public class Cart {
    String userName;
    String cartId;
    BigDecimal totalPrice;

    public String getUserName() {
        return userName;
    }

    public String getCartId() {
        return cartId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
