package com.xupt.bookshop.model.admin;

import com.xupt.bookshop.model.enums.BookState;
import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public class UnfinishedItemForQuery {
    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 拍品名字
     */
    private String itemName;
    /**
     * 拍品状态 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败
     */
    private BookState bookState;
    /**
     * 拍卖开始时间
     */
    private DateTime startTime;
    /**
     * 拍卖结束时间
     */
    private DateTime endTime;
    /**
     * 起拍价
     */
    private Money startPrice;
    /**
     * 加价幅度, 默认1, 单位元
     */
    private Money stepPrice;
    /**
     * 保留价格
     */
    private Money reversePrice;
    /**
     * 当前价格
     */
    private Money currentPrice;
    /**
     * 参与该拍品竞拍人数
     */
    private int auctionCount;
    /**
     * 订阅人数
     */
    private int subscriptionCount;
    /**
     * 浏览人数
     */
    private int browseCount;

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

    public BookState getBookState() {
        return bookState;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
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

    public Money getReversePrice() {
        return reversePrice;
    }

    public void setReversePrice(Money reversePrice) {
        this.reversePrice = reversePrice;
    }

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
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

    public int getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }
}
