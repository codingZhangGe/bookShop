package com.qunar.qauction.common.exceptions;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class ParameterException extends Exception {
    private static final long serialVersionUID = 5947757003417317688L;

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

}
