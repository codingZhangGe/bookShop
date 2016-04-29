package com.xupt.bookshop.model.userauction;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionOrderSuccess {

    private String itemId;

    private String itemName;

    private DateTime auctionTime;

    private Money auctionPrice;

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

    public DateTime getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(DateTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Money getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Money auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }
}
