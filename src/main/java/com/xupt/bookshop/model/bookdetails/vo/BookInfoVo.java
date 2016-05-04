package com.xupt.bookshop.model.bookdetails.vo;

import com.xupt.bookshop.model.enums.BookState;

import java.math.BigDecimal;
import java.util.List;

/**图书详细信息
 * Created by zhangge on 16-4-25.
 */
public class BookInfoVo {

    /**
     * 图书id
     */
    String BookId;
    /**
     * 图书名称
     */
    String BookName;
    /**
     * 图书描述
     */
    String description;
    /**
     * 图书价格
     */

    BigDecimal Price;
    /**
     * 折扣
     */
    int discount;
    /**
     * 折扣价
     */
    BigDecimal currentPrice;
    /**
     * 出版社
     */
    String publish;

    /**
     * 作者
     */
    String author;
    /**
     * 浏览人数
     */
    String browseCount;
    /**
     * 购买人数
     */
    String buyCount;
    /**
     * 剩余量
     */
    String  surplus;


    /**
     * 状态
     */
    BookState bookState;
    /**
     * 图片
     */
    List<String> urlList;

    public String getBookId() {
        return BookId;
    }

    public String getBookName() {
        return BookName;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public int getDiscount() {
        return discount;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public String getPublish() {
        return publish;
    }

    public String getAuthor() {
        return author;
    }

    public String getBrowseCount() {
        return browseCount;
    }

    public String getBuyCount() {
        return buyCount;
    }

    public String getSurplus() {
        return surplus;
    }

    public BookState getBookState() {
        return bookState;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBrowseCount(String browseCount) {
        this.browseCount = browseCount;
    }

    public void setBuyCount(String buyCount) {
        this.buyCount = buyCount;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
