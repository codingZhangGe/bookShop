package com.xupt.bookshop.service.cart.impl;

import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.common.utils.UUIDGenerator;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.service.cart.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**购物车操作
 * Created by zhangge on 16-4-27.
 */

@Service("CartService")
public class CartServiceImpl implements CartService {

    @Resource
    CartDao cartDao;


    /**
     *显示购物车详细信息
     * @param username
     * @return
     */
    @Override
    public List<CartItem> categoryDetail(String username) {
       return   cartDao.queryCartDetail(username);

    }
    // 用户登陆创建购物车
    @Override
    public ResultOfRequest createCategoryWithUser(String username) {
        ResultOfRequest resultOfRequest=new ResultOfRequest();
        com.xupt.bookshop.model.cart.Cart cart=new com.xupt.bookshop.model.cart.Cart();
        cart.setUserName(username);
        cart.setCartId(UUIDGenerator.getUUID());
        cartDao.insertCart(cart);
        resultOfRequest.setCode(Constants.ADD_CATEGORY_SUCC);
        resultOfRequest.setResult(true);
        resultOfRequest.setMessage("创建用户购物车成功");
             return resultOfRequest;
    }

    @Override
    public ResultOfRequest deleteCartItem(String bookId) {
        ResultOfRequest resultOfRequest=new ResultOfRequest();
        int result = cartDao.deleteCategoryItem(bookId);
        if(result<=0){
            resultOfRequest.setCode(Constants.DELETE_CATEGORY_FAIL);
            resultOfRequest.setResult(false);
            resultOfRequest.setMessage("删除购物车商品失败");
        }
        else{
            resultOfRequest.setCode(Constants.DELETE_CATEGORY_SUCC);
            resultOfRequest.setResult(true);
            resultOfRequest.setMessage("删除购物车商品成功");
        }
        return resultOfRequest;
    }
}
