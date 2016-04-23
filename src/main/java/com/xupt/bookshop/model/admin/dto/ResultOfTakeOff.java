package com.xupt.bookshop.model.admin.dto;

import com.xupt.bookshop.model.enums.State;
import qunar.api.pojo.Money;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
public class ResultOfTakeOff {
    /**
     * 卖家qtalk
     */
    private String sellerQtalk;
    /**
     * 当前竞价最高人的qtalk
     */
    private String bidderQtalk;
    /**
     * 竞拍物品当前状态
     */
    private State itemState;
    /**
     * 竞拍物品名字
     */
    private String itemName;
    /**
     * 下架结果
     */
    private boolean result;
    /**
     * 下架时竞拍物品的价格
     */
    private Money currentPrice;
    /**
     * 竞拍物品的保留价格
     */
    private Money reversePrice;

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public String getBidderQtalk() {
        return bidderQtalk;
    }

    public void setBidderQtalk(String bidderQtalk) {
        this.bidderQtalk = bidderQtalk;
    }

    public State getItemState() {
        return itemState;
    }

    public void setItemState(State itemState) {
        this.itemState = itemState;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Money getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Money currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Money getReversePrice() {
        return reversePrice;
    }

    public void setReversePrice(Money reversePrice) {
        this.reversePrice = reversePrice;
    }
}
