package com.xupt.bookshop.model.upload;

import java.math.BigDecimal;

import com.ning.http.util.DateUtil;
import com.xupt.bookshop.common.utils.DateTimeUtil;
import com.xupt.bookshop.model.enums.BookState;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import qunar.api.pojo.Money;

/**
 * 上传图书商品信息
 */

public class UploadItemParam {

    /**
     * 图书id
     */
    private String bookId;
    /**
     * 图书名字
     */
    private String bookName;

    /**
     * 类别id
     */
    private int categoryId;
    /**
     * 出版社
     */

    private String publish;

    /**
     * 拍品描述, 不超过100字
     */
    private String description = "";
    /**
     * 作家
     */
    private String author;
    /**
     * 价格
     */

    private BigDecimal price;

    /**
     * 折扣 默认100
     */
    private BigDecimal discount;

    /**
     * 出版日期
     */

    DateTime publishDate= DateTimeUtil.convertToDateTimeByFullFormatter("2016-3-4 23:22:34");
    /**
     * 状态  默认是有货
     */
    BookState state=BookState.OK_TO_ORDER;

    /**
     * 库存
     */

    BigDecimal currentPrice;
    int surplus;



    public int getCategoryId() {
        return categoryId;
    }

    public String getPublish() {
        return publish;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public BigDecimal getPrice() {
        return price;
    }



    public BigDecimal getDiscount() {
        return discount;
    }

    public DateTime getPublishDate() {
        return publishDate;
    }

    public int getSurplus() {
        return surplus;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public BookState getState() {
        return state;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setPublishDate(DateTime publishDate) {
        this.publishDate = publishDate;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public void setCurrentPrice(BigDecimal price1,BigDecimal discount)
    {
        this.currentPrice = price1.multiply(discount.divide(new BigDecimal(100)));
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
}
