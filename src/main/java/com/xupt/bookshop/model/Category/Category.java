package com.xupt.bookshop.model.Category;

import java.util.Map;

/**
 * @author ge.zhang created on 16-4-18
 * @version 1.0
 */
public class Category {

    /**
     * 类别
     */
    private String categoryName;
    private int categoryId;
    private  int parentId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
