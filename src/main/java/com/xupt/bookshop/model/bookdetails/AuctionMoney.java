package com.xupt.bookshop.model.bookdetails;

import qunar.api.pojo.Money;

/**
 * Created by zhangge on 16-4-19.
 */
public class AuctionMoney {

    private String itemId;
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

    public Money getStartPrice() {
        return startPrice;
    }

    public Money getStepPrice() {
        return stepPrice;
    }

    public Money getReservePrice() {
        return reservePrice;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setStartPrice(Money startPrice) {
        this.startPrice = startPrice;
    }

    public void setStepPrice(Money stepPrice) {
        this.stepPrice = stepPrice;
    }

    public void setReservePrice(Money reservePrice) {
        this.reservePrice = reservePrice;
    }

    @Override
    public String toString() {
        return "AuctionMoney{" + "itemId='" + itemId + '\'' + ", startPrice=" + startPrice + ", stepPrice=" + stepPrice
                + ", reservePrice=" + reservePrice + '}';
    }
}
