package com.xupt.bookshop.common.exceptions;

import qunar.api.pojo.CodeMessage;

import com.xupt.bookshop.common.Constants;

/**
 * @author ge.zhang created on 16-4-20
 * @version 1.0
 */
public class TakeOffFailureException extends Exception implements CodeMessage {

    /**
     * 更改订单失败时, 该商品的itemId
     */
    private String itemName;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public TakeOffFailureException(final String message) {
        super(message);
    }

    public TakeOffFailureException() {
        super("订单状态更改失败错误");
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int getStatus() {
        return Constants.BAD_AUTHORITY_CODE;
    }

    @Override
    public Object getData() {
        return itemName;
    }
}
