package com.qunar.qauction.model.auctiondetails.param;

import qunar.api.pojo.Money;

/**
 * Created by zhangge on 16-4-20.
 */
public class UpdateDynamic {
    String itemId;
    Money currentPrice;
  String bidderQtalk;
    public String getItemId() {
        return itemId;
    }

    public Money getCurrentMoney() {
        return currentPrice;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setCurrentMoney(Money currentMoney) {
        this.currentPrice = currentMoney;
    }

    public String getBidderQtalk() {
        return bidderQtalk;
    }

    public void setBidderQtalk(String bidderQtalk) {
        this.bidderQtalk = bidderQtalk;
    }

    @Override
    public String toString() {
        return "UpdateDynamic{" +
                "itemId='" + itemId + '\'' +
                ", currentMoney=" + currentPrice +
                '}';
    }
}
