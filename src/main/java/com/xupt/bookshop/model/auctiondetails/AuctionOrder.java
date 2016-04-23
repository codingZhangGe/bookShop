package com.xupt.bookshop.model.auctiondetails;

import org.joda.time.DateTime;
import qunar.api.pojo.Money;

/**
 * 竞拍订单model
 *
 * @author yunfeng.yang created on 16-4-15
 * @version 1.0
 */
public class AuctionOrder {
    /**
     * 主键id
     */
    private int id;
    /**
     * 对应拍品id
     */
    private String itemId;
    /**
     * 竞拍者qtalk
     */
    private String bidderQtalk;
    /**
     * 竞拍价格
     */
    private Money auctionPrice;
    /**
     * 竞拍时间
     */
    private DateTime auctionTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getBidderQtalk() {
        return bidderQtalk;
    }

    public void setBidderQtalk(String bidderQtalk) {
        this.bidderQtalk = bidderQtalk;
    }

    public Money getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Money auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public DateTime getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(DateTime auctionTime) {
        this.auctionTime = auctionTime;
    }
}
