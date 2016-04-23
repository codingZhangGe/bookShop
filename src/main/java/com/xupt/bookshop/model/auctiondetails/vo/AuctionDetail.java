package com.xupt.bookshop.model.auctiondetails.vo;

import com.xupt.bookshop.common.utils.DateTimeUtil;
import com.xupt.bookshop.model.enums.OldDegree;
import com.xupt.bookshop.model.enums.State;
import org.joda.time.DateTime;
import qunar.api.pojo.Money;

import java.util.List;

/**
 * 正在竞拍物品的信息 Created by zhangge on 16-4-17.
 */
public class AuctionDetail {
    /**
     * 商品id
     */

    private String itemId;
    /**
     * 拍品的名称
     */
    private String itemName;
    /**
     * 开始时间
     */
    private DateTime startTime;
    /**
     * 结束时间
     */
    private DateTime endTime;
    /**
     * 起拍价格
     */
    private Money startPrice;
    /**
     * 当前价格
     */
    private Money auctionPrice;
    /**
     * 加价幅度
     */
    private Money stepPrice;
    /**
     * 成色
     */
    private OldDegree oldDegree;
    /**
     * 状态
     */
    private State state;
    /**
     * 卖家信息
     */
    private String sellerQtalk;
    /**
     * 报名人数
     */
    private int auctionCount;
    /**
     * 浏览人数
     */
    private int browseCount;
    /**
     * 图片地址
     */
    private List<String> urlList;

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public Money getStartPrice() {
        return startPrice;
    }

    public Money getAuctionPrice() {
        return auctionPrice;
    }

    public Money getStepPrice() {
        return stepPrice;
    }

    public Enum getOldDegree() {
        return oldDegree;
    }

    public int getAuctionCount() {
        return auctionCount;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public State getState() {
        return state;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartPrice(Money startPrice) {
        this.startPrice = startPrice;
    }

    public void setAuctionPrice(Money auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public void setStepPrice(Money stepPrice) {
        this.stepPrice = stepPrice;
    }

    public void setOldDegree(OldDegree oldDegree) {
        this.oldDegree = oldDegree;
    }

    public void setAuctionCount(int auctionCount) {
        this.auctionCount = auctionCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AuctionDetail{" + "itemId='" + itemId + '\'' + ", itemName='" + itemName + '\'' + ", startTime="
                + DateTimeUtil.getStandardStr(startTime) + ", endTime=" + DateTimeUtil.getStandardStr(endTime)
                + ", startPrice=" + startPrice + ", auctionPrice=" + auctionPrice + ", stepPrice=" + stepPrice
                + ", oldDegree=" + oldDegree.getDescriptions() + ", state=" + state.getDescription() + ", sellerQtalk='"
                + sellerQtalk + '\'' + ", auctionCount=" + auctionCount + ", browseCount=" + browseCount + ", urlList="
                + urlList +

        '}';
    }
}
