package com.xupt.bookshop.web.controller;

import com.xupt.bookshop.common.Monitor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class ErrorController {
    /**
     * 404错误页面
     */
    @RequestMapping("/404")
    public String page404() {
        return "404";
    }

    /**
     * 500错误页面
     */
    @RequestMapping("/500")
    public String page500() {
        return "500";
    }

    /**
     * 502错误页面
     */
    @RequestMapping("/502")
    public String page502() {
        return "502";
    }

    /**
     * 系统错误
     */
    @RequestMapping("/system")
    public String systemError() {
        Monitor.EX_UNHANDLED_COUNT.inc();
        return "500";
    }
}
