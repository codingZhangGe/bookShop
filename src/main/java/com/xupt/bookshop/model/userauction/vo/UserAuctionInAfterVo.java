package com.xupt.bookshop.model.userauction.vo;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * 用户参加的拍卖物品信息类
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionInAfterVo {

    private String itemName;

    private String imgUrl;

    private Money finalPrice;

    private DateTime endTime;

    private String sellerQtalk;

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

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }
}
