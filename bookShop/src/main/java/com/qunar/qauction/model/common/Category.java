package com.qunar.qauction.model.common;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public class Category {
    /**
     * 主键id
     */
    private long id;
    /**
     * 类别
     */
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
