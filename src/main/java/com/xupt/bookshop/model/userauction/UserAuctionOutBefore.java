package com.xupt.bookshop.model.userauction;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionOutBefore {

    private String itemId;

    private String itemName;

    private Money startPrice;

    private DateTime startTime;

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

    public Money getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Money startPrice) {
        this.startPrice = startPrice;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }
}
