package com.xupt.bookshop.common.exceptions;

import qunar.api.pojo.CodeMessage;


/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class ParameterException extends Exception implements CodeMessage {

    private String badParameter;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public ParameterException(final String message) {
        super(message);
    }

    public ParameterException() {
        super("参数错误");
    }

  //  @Override
//    public int getStatus() {
//        return Constants.FAILED_CODE;
//    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public Object getData() {
        return badParameter;
    }

    public String getBadParameter() {
        return badParameter;
    }

    public void setBadParameter(String badParameter) {
        this.badParameter = badParameter;
    }
}
