package com.qunar.qauction.model.auctiondetails.vo;

import qunar.api.pojo.Money;

/**
 * 竞价成功返回给前端的数据 Created by zhangge on 16-4-20.
 */
public class AuctionBidderSuc {
    String itemId;
    Money bidderMoney;

    public String getItemId() {
        return itemId;
    }

    public Money getBidderMoney() {
        return bidderMoney;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setBidderMoney(Money bidderMoney) {
        this.bidderMoney = bidderMoney;
    }

    @Override
    public String toString() {
        return "AuctionBidderSuc{" + "itemId='" + itemId + '\'' + ", bidderMoney=" + bidderMoney + '}';
    }
}
