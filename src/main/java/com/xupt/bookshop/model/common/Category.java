package com.xupt.bookshop.model.common;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
public class Category {
    /**
     * 主键id
     */
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
