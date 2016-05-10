package com.xupt.bookshop.model.bookdetails.dto;

/**
 * @author ge.zhang created on 16-4-24
 * @version 1.0
 */
public class ResultOfUpdateAndCreateOrder {
    private boolean result;
    private int code;
    private String message;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
