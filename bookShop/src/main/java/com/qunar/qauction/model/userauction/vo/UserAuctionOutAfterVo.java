package com.qunar.qauction.model.userauction.vo;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-20.
 */
public class UserAuctionOutAfterVo {

    private String itemName;

    private String imgUrl;

    private Money finalPrice;

    private DateTime endTime;

    private String buyerQtalk;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Money getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Money finalPrice) {
        this.finalPrice = finalPrice;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public String getBuyerQtalk() {
        return buyerQtalk;
    }

    public void setBuyerQtalk(String buyerQtalk) {
        this.buyerQtalk = buyerQtalk;
    }
}
