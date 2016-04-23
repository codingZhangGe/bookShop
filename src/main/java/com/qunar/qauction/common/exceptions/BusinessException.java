package com.qunar.qauction.common.exceptions;

import com.qunar.qauction.common.Constants;
import qunar.api.pojo.CodeMessage;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class BusinessException extends Exception implements CodeMessage {
    private static final long serialVersionUID = -1439632423948853212L;

    /**
     * 字符串参数构造
     *
     * @param message 异常信息
     */
    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException() {
        super("业务逻辑错误");
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
