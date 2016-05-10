package com.xupt.bookshop.web.controller;


import com.xupt.bookshop.common.Monitor;
import com.xupt.bookshop.common.exceptions.AuthorityException;
import com.xupt.bookshop.common.exceptions.BusinessException;
import com.xupt.bookshop.common.exceptions.ExternalException;
import com.xupt.bookshop.common.exceptions.NumberToLargeException;
import com.xupt.bookshop.common.exceptions.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import qunar.web.spring.annotation.JsonBody;

/**
 * @author ge.zhang created on 16-4-14
 * @version 1.0
 */
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    @JsonBody
    public Object customExceptionHandler(Exception e) {
        if (e instanceof AuthorityException) {
            Monitor.EX_AUTHORITY_COUNT.inc();
            LOGGER.warn("[AUTHORITY]: ", e);
            return e;
        } else if (e instanceof BusinessException) {
            Monitor.EX_BUSINESS_COUNT.inc();
            LOGGER.warn("[BUSINESS]: ", e);
            return e;
        } else if (e instanceof ParameterException) {
            Monitor.EX_PARAMETER_COUNT.inc();
            LOGGER.warn("[PARAMETER]: ", e);
            return e;
        } else if (e instanceof ExternalException) {
            Monitor.EX_EXTERNAL_COUNT.inc();
            LOGGER.warn("[EXTERNAL]: ", e);
            return e;
        } else if (e instanceof NumberToLargeException) {
            LOGGER.error("to much file upload", e);
            return e;
        } else {
            Monitor.EX_UNHANDLED_COUNT.inc();
            LOGGER.error("[ERROR]: Unhandled - ", e);
            return e;
        }
    }

}
