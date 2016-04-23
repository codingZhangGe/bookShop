package com.qunar.qauction.model.common;

import qunar.api.pojo.Money;

/**
 * @author yunfeng.yang created on 16-4-15
 * @version 1.0
 */
public class UnfinishedItemDynamicInfo {

    /**
     * 主键id
     */
    private long id;
    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 当前价格
     */
    private Money currentPrice;
    /**
     * 当前竞价最高者qtalk
     */
    private String currentBidderQtalk;
    /**
     * 报名人数
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrentBidderQtalk() {
        return currentBidderQtalk;
    }

    public void setCurrentBidderQtalk(String currentBidderQtalk) {
        this.currentBidderQtalk = currentBidderQtalk;
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
