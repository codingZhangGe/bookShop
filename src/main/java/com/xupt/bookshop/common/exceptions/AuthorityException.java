package com.xupt.bookshop.common.exceptions;

import qunar.api.pojo.CodeMessage;

import com.xupt.bookshop.common.Constants;

/**
 * @author ge.zhang created on 16-4-14
 * @version 1.0
 */
public class AuthorityException extends Exception implements CodeMessage {
    private static final long serialVersionUID = -824774517021673880L;

    /**
     * 权限异常时, 该用户的用户名
     */
    private String username;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public AuthorityException(final String message) {
        super(message);
    }

    public AuthorityException() {
        super("权限错误");
    }

    private void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int getStatus() {
        return Constants.BAD_AUTHORITY_CODE;
    }

    @Override
    public Object getData() {
        return username;
    }
}
