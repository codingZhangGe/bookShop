package com.xupt.bookshop.model;

import qunar.api.pojo.Money;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author yunfeng.yang created on 16-4-23
 * @version 1.0
 */
public class ResultOfRequest<T> {
    /**
     * 判断结果
     */
    @JsonIgnore
    private boolean result;
    /**
     * 错误产生的消息
     */
    @JsonIgnore
    private String message;
    /**
     * 错误代码
     */
    @JsonIgnore
    private int code;

    private T Data;


    public boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return Data;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        Data = data;
    }
}
