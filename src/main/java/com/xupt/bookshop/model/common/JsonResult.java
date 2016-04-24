/*
 * Copyright (c) 2015 Qunar.com. All Rights Reserved.
 */
package com.xupt.bookshop.model.common;

import java.io.Serializable;

/**
 * 返回Json格式
 *
 * @param <T>
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 6989703177531051829L;

    private int status;
    private String message;
    private T data;

    public JsonResult() {
    }

    public JsonResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> JsonResult<T> succ() {
        return new JsonResult<T>(0, "成功", null);
    }

    public static <T> JsonResult<T> succ(T data) {
        return new JsonResult<T>(0, "成功", data);
    }

    public static <T> JsonResult<T> fail(String message) {
        return new JsonResult<T>(-1, message, null);
    }

    public static <T> JsonResult<T> fail(int status, String message) {
        return new JsonResult<T>(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
