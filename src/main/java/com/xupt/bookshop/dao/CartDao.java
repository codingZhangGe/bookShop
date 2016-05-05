package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.cart.Cart;
import com.xupt.bookshop.model.cart.CartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
@Repository
public interface CartDao {
    /**
     * 插入购物车详细信息
     * @param cartItem
     */
    void  insertCartitem(@Param("cartItem")CartItem cartItem);

    /**
     * 创建购物车
     * @param cart
     */
    void insertCart(@Param("cart") Cart cart);

    /**
     * 查询购物车详情
     * @param username
     * @return
     */
    List<CartItem> queryCartDetail(String username);

    /**
     * 查询购物车
     * @param username
     * @return
     */
    String queryCartId(@Param("username")String username);

    /**
     * 删除购物车
     * @param usrname
     * @return
     */
    int removeCartItem(String usrname);

    /**
     * 删除购物车详情
     * @param bookId
     * @return
     */
    int deleteCategoryItem(@Param("list")List<String> bookId);
   //清空详情
    void updateCategoryItem();


}
