package com.qunar.qauction.common.exceptions;

/**
 * Created by liuyanjiang on 16-4-19. 上传的文件数量太多异常
 */
public class NumberToLargeException extends Exception {

    public NumberToLargeException(String message) {
        super(message);
    }

    public NumberToLargeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberToLargeException(Throwable cause) {
        super(cause);
    }
}
