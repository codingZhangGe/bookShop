package com.xupt.bookshop.service.category.impl;

import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.service.category.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**购物车操作
 * Created by zhangge on 16-4-27.
 */

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

    @Resource
    CartDao cartDao;


    /**
     *显示购物车详细信息
     * @param username
     * @return
     */
    @Override
    public List<CartItem> categoryDetail(String username) {
       return   cartDao.queryCategoryDetail(username);
    }

    //TODO 根据购物车创建订单
    @Override
    public void createCategoryWithUser(String username) {

    }
}
