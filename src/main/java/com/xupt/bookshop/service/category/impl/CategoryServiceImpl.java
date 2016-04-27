package com.xupt.bookshop.service.category.impl;

import com.xupt.bookshop.dao.CategoryDao;
import com.xupt.bookshop.model.bookdetails.vo.CategoryItem;
import com.xupt.bookshop.service.category.CategoryService;

import javax.annotation.Resource;

/**
 * Created by zhangge on 16-4-27.
 */
public class CategoryServiceImpl implements CategoryService{

    @Resource
    CategoryDao categoryDao;


    /**
     *显示购物车详细信息
     * @param username
     * @return
     */
    @Override
    public CategoryItem categoryDetail(String username) {
       return   categoryDao.queryCategoryDetail(username);
    }

    @Override
    public void createCategoryWithUser(String username) {

    }
}
