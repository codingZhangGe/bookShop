package com.qunar.qauction.model.home;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * Description: AuctioningInfo
 *
 * @author lingtong.fu
 * @version 2016-04-19 21:39
 */
public class AuctioningVo {

    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 拍品名字
     */
    private String itemName;
    /**
     * 拍卖开始时间
     */
    private DateTime startTime;
    /**
     * 拍卖结束时间
     */
    private DateTime endTime;
    /**
     * 拍品图片URL
     */
    private String itemPictureURL;

    /**
     * 类别id
     */
    private int categoryId;
    /**
     * 浏览人数
     */
    private int browseCount;
    /**
     * 参与该拍品竞拍人数
     */
    private int auctionCount;
    /**
     * 订阅人数
     */
    private int subscriptionCount;
    /**
     * 拍品状态 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败
     */
    private int state;
    /**
     * 起拍价
     */
    private Money startPrice;
    /**
     * 加价幅度, 默认1, 单位元
     */
    private Money stepPrice;
    /**
     * 当前价格
     */
    private Money currentPrice;

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

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }
    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public String getItemPictureURL() {
        return itemPictureURL;
    }

    public void setItemPictureURL(String itemPictureURL) {
        this.itemPictureURL = itemPictureURL;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public int getAuctionCount() {
        return auctionCount;
    }

    public void setAuctionCount(int auctionCount) {
        this.auctionCount = auctionCount;
    }

    public int getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Money getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Money startPrice) {
        this.startPrice = startPrice;
    }

    public Money getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(Money stepPrice) {
        this.stepPrice = stepPrice;
    }

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
    }
}
