package com.xupt.bookshop.service.category;

import com.xupt.bookshop.model.bookdetails.vo.CategoryItem;

/**
 * Created by zhangge on 16-4-27.
 */
public interface CategoryService {

    CategoryItem categoryDetail(String username);
    public void createCategoryWithUser(String username);
}
