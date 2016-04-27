package com.xupt.bookshop.model.admin;

import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.State;
import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public class FinishedItemInfoForQuery {
    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 拍品名字
     */
    private String itemName;
    /**
     * 卖家qtalk
     */
    private String sellerQtalk;
    /**
     * 买家qtalk
     */
    private String buyerQtalk;
    /**
     * 拍品状态 1-未开始, 2-竞拍中, 3-竞拍成功, 4-竞拍失败
     */
    private State state;
    /**
     * 拍卖开始时间
     */
    private DateTime startTime;
    /**
     * 拍卖结束时间
     */
    private DateTime endTime;
    /**
     * 几成新
     */
    private OrderState orderState;
    /**
     * 起拍价
     */
    private Money startPrice;
    /**
     * 加价幅度, 默认1, 单位元
     */
    private Money stepPrice;
    /**
     * 最终价格
     */
    private Money finalPrice;
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

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public String getBuyerQtalk() {
        return buyerQtalk;
    }

    public void setBuyerQtalk(String buyerQtalk) {
        this.buyerQtalk = buyerQtalk;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public Money getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Money finalPrice) {
        this.finalPrice = finalPrice;
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

    public OrderState getOldDegree() {
        return orderState;
    }

    public void setOldDegree(OrderState orderState) {
        this.orderState = orderState;
    }
}
