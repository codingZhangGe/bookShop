package com.xupt.bookshop.model.Category;


import com.google.common.collect.Multimap;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangge on 16-5-19.
 */
public class CategoryVo {
    private String categoryName;

    private Map<String,List<Category>> childCategory;

    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Map<String, List<Category>> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Map<String, List<Category>> childCategory) {
        this.childCategory = childCategory;
    }
}
