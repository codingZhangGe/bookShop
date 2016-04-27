package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.bookdetails.vo.CategoryItem;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangge on 16-4-27.
 */
public interface CategoryDao {

    //TODO sql 语句插入购物车详情
    void  insertCategoryitem(@Param("categoryItem")CategoryItem categoryItem);

    void insertCategory(@Param("username") String username);

    //TODO 查询购物车的详细信息

    CategoryItem queryCategoryDetail(String username);
}
