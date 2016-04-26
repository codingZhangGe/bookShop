package com.xupt.bookshop.model.bookdetails.dto;

/**
 * @author yunfeng.yang created on 16-4-23
 * @version 1.0
 */
public class ResultOfDoAuction {
    private boolean result;
    private String itemId;
    private String message;
    private int code;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
