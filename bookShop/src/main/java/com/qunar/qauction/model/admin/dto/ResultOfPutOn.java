package com.qunar.qauction.model.admin.dto;

import qunar.api.pojo.Money;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
public class ResultOfPutOn {
    /**
     * 上架竞拍物品结果
     */
    private boolean result;
    /**
     * 卖家qtalk
     */
    private String sellerQtalk;
    /**
     * 竞拍物品名称
     */
    private String itemName;
    /**
     * 竞拍物品当前价格
     */
    private Money currentPrice;
    /**
     * 竞拍物品保留价格
     */
    private Money reversePrice;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getSellerQtalk() {
        return sellerQtalk;
    }

    public void setSellerQtalk(String sellerQtalk) {
        this.sellerQtalk = sellerQtalk;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
