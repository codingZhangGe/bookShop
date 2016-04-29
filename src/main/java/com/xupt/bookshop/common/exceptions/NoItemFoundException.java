package com.xupt.bookshop.common.exceptions;

import qunar.api.pojo.CodeMessage;

import com.xupt.bookshop.common.Constants;

/**
 * @author yunfeng.yang created on 16-4-22
 * @version 1.0
 */
public class NoItemFoundException extends RuntimeException implements CodeMessage {
    /**
     * 上架商品失败时, 该商品的itemId
     */
    private String itemId;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public NoItemFoundException(final String message) {
        super(message);
    }

    public NoItemFoundException() {
        super("上架商品失败错误");
    }

    @Override
    public int getStatus() {
        return Constants.NO_ITEM_FOUND_CODE;
    }

    @Override
    public Object getData() {
        return itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
