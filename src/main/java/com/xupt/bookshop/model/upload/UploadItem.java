package com.xupt.bookshop.model.upload;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import qunar.api.pojo.Money;



public class UploadItem {

    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 拍品名字
     */
    private String itemName;

    /**
     * 类别id
     */
    private int categoryId;
    /**
     * 卖家qtalk
     */
    @JsonIgnore
    private String sellerQtalk;

    /**
     * 拍品描述, 不超过100字
     */
    private String description = "";
    /**
     * 拍卖开始时间
     */
    private DateTime startTime;
    /**
     * 拍卖结束时间
     */

    private DateTime endTime;
    /**
     * 起拍价
     */
    private Money startPrice;
    /**
     * 加价幅度, 默认1, 单位元
     */
    private Money stepPrice;
    /**
     * 保留价格, 当最终拍卖价格小于保留价格, 则流拍
     */
    private Money reservePrice;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = Integer.valueOf(categoryId);
    }

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public Money getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = Money.of(new BigDecimal(startPrice));
    }

    public Money getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(String stepPrice) {
        this.stepPrice = Money.of(new BigDecimal(stepPrice));
    }

    public Money getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(String reservePrice) {
        this.reservePrice = Money.of(new BigDecimal(reservePrice));
    }

}
