package com.xupt.bookshop.model.order;

import java.math.BigDecimal;

/**
 * Created by zhangge on 16-5-17.
 */
public class OrderItem {
    //购物车信息： 商品名称 价格 折扣价 购买数量 商铺
    String orderId;
    String bookName;
    BigDecimal price;
    BigDecimal currentPrice;
    int buyNum;

    public String getOrderId() {
        return orderId;
    }

    public String getBookName() {
        return bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
