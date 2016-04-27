package com.xupt.bookshop.model.cart;

import java.math.BigDecimal;

/**
 * Created by zhangge on 16-4-26.
 */
public class CartItem {

    //购物车信息： 商品名称 价格 折扣价 购买数量 商铺
    String categoryId;
    String userName;
    String bookID;
    String bookName;
    BigDecimal price;
    BigDecimal currentPrice;
    int buyNum;


    public String getBookID() {
        return bookID;
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


    public void setBookID(String bookID) {
        this.bookID = bookID;
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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
