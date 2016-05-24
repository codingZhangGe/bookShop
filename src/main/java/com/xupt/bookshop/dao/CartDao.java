package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.cart.Cart;
import com.xupt.bookshop.model.cart.CartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**购物车
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

    CartItem queryCartDetailsByBookId(@Param("bookId") String bookId);
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

    /**
     * 增加购买数量
     */
    void updateCartDetailCount(@Param("bookId")String bookId);

    int deletecartItem(@Param("bookId")String bookId);
    int updateTotalPrice(@Param("totalPrice") BigDecimal totalPrice,@Param("username")String username);
    BigDecimal selectTotalPrice(@Param("username") String username);

}
