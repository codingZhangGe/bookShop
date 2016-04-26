package com.xupt.bookshop.model.bookdetails;

import com.xupt.bookshop.model.enums.Category;
import com.xupt.bookshop.model.enums.State;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 图书id，图书名称，
 描述，价格，
 折扣，折扣价，
 作家，出版社，
 购买人数，浏览人数,
 剩余数量,商铺
 出版时间，分类
 收藏人数 ，状态-->
 * 上架的图书信息 Created by zhangge on 16-4-17.
 */
public class BookDetail {
    /**
     * 商品id
     */

    private String bookId;
    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书描述
     */
    private String description;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 折扣价格
     */
    private BigDecimal currentPrice;
    /**
     * 折扣
     */
    private int  discount;

    /**
     * 类别
     */
    private Category category;
    /**
     * 状态
     */
    private State state;
    /**
     * 出版社
     */
    private String publish;
    /**
     *作者
     */
    private String athor;
    /**
     * 剩余
     */
    private int surplus;

  private String shopName;
    private int buyCount;
    private int browseCount;
    private int collectCount;

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public Category getCategory() {
        return category;
    }

    public State getState() {
        return state;
    }

    public String getPublish() {
        return publish;
    }

    public String getAthor() {
        return athor;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setAthor(String athor) {
        this.athor = athor;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public String getShopName() {
        return shopName;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }
}
