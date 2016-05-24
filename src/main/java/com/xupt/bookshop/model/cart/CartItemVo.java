package com.xupt.bookshop.model.cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zhangge on 16-5-24.
 */
public class CartItemVo {
    List<CartItem> cartItemList;
    BigDecimal totalPrice;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
