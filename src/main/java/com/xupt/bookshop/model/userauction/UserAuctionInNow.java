package com.xupt.bookshop.model.userauction;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionInNow {

    private String itemId;

    private String itemName;

    private Money currentPrice;

    private DateTime endTime;

    private String sellerQtalk;

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

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }
}
