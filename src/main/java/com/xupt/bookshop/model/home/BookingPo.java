package com.xupt.bookshop.model.home;



import java.math.BigDecimal;

/**
 *首页展示图书信息
 */
public class BookingPo {
    /**
     * 图书id
     */
    private String bookId;
    /**
     * 图书名字
     */
    private String bookName;
    /**
     * 当期价格
     */
    private BigDecimal currentPrice;
    /**
     * 价格 如果没有折扣，那么当前价格就是此价格
     */
    private BigDecimal Price;
    /**
     * 折扣
     */
    private int  discount;
    /**
     * 浏览人数
     */
    private  int browseCount;
    /**
     * 购买人数
     */
    private int buyCount;
    /**
     * 类别id
     */
    private String categoryName;

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
