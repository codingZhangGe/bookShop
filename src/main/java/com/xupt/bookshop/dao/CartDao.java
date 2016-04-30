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

    void  insertCategoryitem(@Param("categoryItem")CartItem cartItem);

    void insertCategory(@Param("cart") Cart cart);

    List<CartItem> queryCategoryDetail(String username);

    int removeCartItem(String usrname);

     int deleteCategoryItem(String bookId);
    int deleteCategoryItemByuser(String username);

}
