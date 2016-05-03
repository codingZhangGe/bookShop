package com.xupt.bookshop.model.bookdetails;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import org.joda.time.DateTime;

import java.math.BigDecimal;

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
    private String categoryName;
    /**
     * 状态
     */
    private BookState bookState;
    /**
     * 出版社
     */
    private String publish;
    /**
     *作者
     */
    private String author;
    /**
     * 剩余
     */
    private int surplus;
    private DateTime publishDate;
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

    public DateTime getPublishDate() {
        return publishDate;
    }

    public BookState getBookState() {
        return bookState;
    }

    public String getPublish() {
        return publish;
    }

    public String getAthor() {
        return author;
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


    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setAthor(String athor) {
        this.author = athor;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPublishDate(DateTime publishDate) {
        this.publishDate = publishDate;
    }
}
