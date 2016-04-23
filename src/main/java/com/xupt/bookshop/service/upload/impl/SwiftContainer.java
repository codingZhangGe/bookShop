package com.xupt.bookshop.service.upload.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.javaswift.joss.model.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by liuyanjiang on 16-4-17.
 */
public class SwiftContainer {
    private String name;
    @Resource
    private SwiftClient client;
    private Container container;
    private Logger logger = LoggerFactory.getLogger(SwiftContainer.class);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public void initContainer() {// 根据accout初始化container
        logger.info("init container:{}", name);
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name));
        this.container = client.getAccount().getContainer(name);
    }
}
