package com.xupt.bookshop.common.datasource;

/**
 * 利用TrheadLocal 解决线程安全问题 Created by zhangge on 16-4-22.
 */
public class DynamicDataSourceHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 绑定当前线程数据源路由的key 使用完成必须进行删除
     */
    public static void setDataSource(String datasource) {
        contextHolder.set(datasource);
    }

    /**
     * 获取当前线程的数据源路由的key
     */
    public static String getDataSource() {
        return contextHolder.get();
    }

    /**
     * 删除与当前线程绑定的数据源路由的key
     */
    public static void clearCustomerType() {
        contextHolder.remove();
    }

}
