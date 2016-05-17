package com.xupt.bookshop.service.userinfo;

import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.enums.OrderState;

/**
 *
 * Created by ge.zhang on 16-4-18.
 */
public interface UserInfoService {

    /**
     * 更具状态查询用户的订单
     */

    public PageResult queryOrderByState(Integer currentPage, Integer PageSize, String username, OrderState orderState);
    /**
     * 查询用户所有订单
     */

    public PageResult queryAllOrder(Integer currentPage, Integer PageSize,String username);

}
