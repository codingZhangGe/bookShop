package com.xupt.bookshop.common.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 路由中介配置路由，根据Key 动态的切换适合的DataSource Created by zhangge on 16-4-22.
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    Logger LOGGER = LoggerFactory.getLogger(DynamicRoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        LOGGER.info("[数据库选择],{}", DynamicDataSourceHolder.getDataSource());
        return DynamicDataSourceHolder.getDataSource();

    }
}
