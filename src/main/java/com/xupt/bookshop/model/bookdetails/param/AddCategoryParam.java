package com.xupt.bookshop.model.bookdetails.param;

import com.xupt.bookshop.model.bookdetails.param.validation.ItemIdValidator;
import org.hibernate.validator.constraints.Range;



/**
 * @author ge.zhang created on 16-4-23
 * @version 1.0
 */
public class AddCategoryParam {
    /**
     * 图书的Id
     */
    @ItemIdValidator(message = "竞拍物品的itemId不满足要求")
    private String itemId;

    /**
     * 图书的状态state
     */
    @Range(min = 1, max = 4, message = "竞拍物品状态取值只能是1, 2, 3, 4")
    private Integer state;

    /**
     * 购买数量
     */
    @Range(min = 1)
    private int buyNumber;

    /**
     * 购买者id 通过cookie获得
     */
    private String userName;

    public String getItemId() {
        return itemId;
    }

    public Integer getState() {
        return state;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
