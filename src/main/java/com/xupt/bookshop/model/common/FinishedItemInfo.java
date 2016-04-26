package com.xupt.bookshop.model.common;

import com.xupt.bookshop.model.enums.Category;
import com.xupt.bookshop.model.enums.State;
import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * 竞拍结束后拍卖物品model
 *
 * @author yunfeng.yang created on 16-4-15
 * @version 1.0
 */
public class FinishedItemInfo {
    /**
     * 主键id
     */
    private long id;
    /**
     * 拍品id
     */
    private String itemId;
    /**
     * 拍品名字
     */
    private String itemName;
    /**
     * 成色, 1-1成新, 2-2成新, 3-3成新, 4-4成新, 5-5成新, 6-6成新, 7-7成新, 8-8成新, 9-9成新, 10-10成新, 默认为5
     */
    private Category category;
    /**
     * 类别id
     */
    private int categoryId;
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
     * 拍品描述, 不超过100字
     */
    private String description;
    /**
     * 拍卖开始时间
     */
    private DateTime startTime;
    /**
     * 拍卖结束时间
     */
    private DateTime endTime;
    /**
     * 起拍价格
     */
    private Money startPrice;
    /**
     * 加价幅度, 默认1, 单位元
     */
    private Money stepPrice;
    /**
     * 保留价格, 当最终拍卖价格小于保留价格, 则流拍
     */
    private Money reservePrice;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getOldDegree() {
        return category;
    }

    public void setOldDegree(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Money getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Money reservePrice) {
        this.reservePrice = reservePrice;
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

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemId='" + itemId + '\'' + ", itemName='" + itemName + '\'' + ", oldDegree="
                + category + ", categoryId=" + categoryId + ", sellerQtalk='" + sellerQtalk + '\'' + ", buyerQtalk='"
                + buyerQtalk + '\'' + ", state=" + state + ", description='" + description + '\'' + ", startTime="
                + startTime + ", endTime=" + endTime + ", stepPrice=" + stepPrice + ", reservePrice=" + reservePrice
                + ", finalPrice=" + finalPrice + ", auctionCount=" + auctionCount + ", subscriptionCount="
                + subscriptionCount + ", browseCount=" + browseCount + '}';
    }
}
