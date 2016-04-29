package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.cart.CartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
@Repository
public interface CartDao {

    //TODO sql 语句插入购物车详情
    void  insertCategoryitem(@Param("categoryItem")CartItem cartItem);

    void insertCategory(@Param("username") String username);

    //TODO 查询购物车的详细信息 sql

    List<CartItem> queryCategoryDetail(String username);

    //TODO 清空cartitem 中此用户的记录 sql
    int removeCartItem(String usrname);


}
