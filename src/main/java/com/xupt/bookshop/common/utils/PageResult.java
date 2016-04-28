package com.xupt.bookshop.common.utils;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Description: 分页结果添加总页数
 *
 * @author ge.zhang
 * @version 2016-04-27 21:21
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -127823970950464250L;
    private int totalSize;          // 总数
    private List<T> pageData;       // 页数据

    public PageResult(int totalSize, List<T> pageData) {
        this.totalSize = totalSize;
        this.pageData = pageData;
    }

    public PageResult() {
        this.totalSize = 0;
        this.pageData = Lists.newArrayList();
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
