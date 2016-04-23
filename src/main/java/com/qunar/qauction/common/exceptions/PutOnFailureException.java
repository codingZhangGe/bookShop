package com.qunar.qauction.common.exceptions;

import com.qunar.qauction.common.Constants;
import qunar.api.pojo.CodeMessage;

/**
 * @author yunfeng.yang created on 16-4-20
 * @version 1.0
 */
public class PutOnFailureException extends Exception implements CodeMessage {

    /**
     * 上架商品失败时, 该商品的itemId
     */
    private String itemName;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public PutOnFailureException(final String message) {
        super(message);
    }

    public PutOnFailureException() {
        super("上架商品失败错误");
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
