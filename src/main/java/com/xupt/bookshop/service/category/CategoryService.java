package com.xupt.bookshop.service.category;

import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;

import java.util.List;

/**
 * Created by zhangge on 16-4-27.
 */
public interface CategoryService {

    List<CartItem> categoryDetail(String username);
    public ResultOfRequest createCategoryWithUser(String username);
    public ResultOfRequest deleteCartItem(String bookId);
}
