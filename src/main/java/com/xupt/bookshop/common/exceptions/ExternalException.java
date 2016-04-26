package com.xupt.bookshop.common.exceptions;

import qunar.api.pojo.CodeMessage;

import com.xupt.bookshop.common.Constants;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class ExternalException extends Exception implements CodeMessage {

    private static final long serialVersionUID = 7387740919824220179L;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public ExternalException(final String message) {
        super(message);
    }

    /**
     * 包装一个throwable
     *
     * @param cause Throwable的对象
     */
    public ExternalException(final Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public ExternalException() {
        super("外部异常");
    }

    @Override
    public int getStatus() {
        return Constants.FAILED_CODE;
    }

    @Override
    public Object getData() {
        return null;
    }
}
