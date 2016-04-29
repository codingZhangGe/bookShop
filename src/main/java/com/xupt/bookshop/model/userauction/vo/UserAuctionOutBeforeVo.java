package com.xupt.bookshop.model.userauction.vo;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * 用户要拍出的物品信息类
 *
 * Created by yangsongbao on 16-4-18.
 */
public class UserAuctionOutBeforeVo {

    private String itemName;

    private String imgUrl;

    private Money startPrice;

    private DateTime startTime;

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
