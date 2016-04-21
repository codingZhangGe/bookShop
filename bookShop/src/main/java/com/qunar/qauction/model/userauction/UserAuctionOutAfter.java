package com.qunar.qauction.model.userauction;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionOutAfter {

    private String itemId;

    private String itemName;

    private Money finalPrice;

    private DateTime endTime;

    private String buyerQtalk;

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
