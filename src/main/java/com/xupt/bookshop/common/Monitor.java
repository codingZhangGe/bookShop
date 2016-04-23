package com.xupt.bookshop.common;

import qunar.metrics.Counter;
import qunar.metrics.Metrics;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public class Monitor {
    // 异常
    public static final Counter EX_PARAMETER_COUNT = Metrics.counter("exception_count").tag("type", "parameter").get();
    public static final Counter EX_BUSINESS_COUNT = Metrics.counter("exception_count").tag("type", "business").get();
    public static final Counter EX_AUTHORITY_COUNT = Metrics.counter("exception_count").tag("type", "authority").get();
    public static final Counter EX_EXTERNAL_COUNT = Metrics.counter("exception_count").tag("type", "external").get();
    public static final Counter EX_UNHANDLED_COUNT = Metrics.counter("exception_count").tag("type", "unhandled").get();
    // HTTP请求
    public static final Counter HTTP_REQUEST_COUNT = Metrics.counter("http_count").get();
}
