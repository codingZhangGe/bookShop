package com.xupt.bookshop.service.userinfo;

import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.order.OrderItemVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionInAfterVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionInNowVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOrderFailVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOrderSuccessVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutAfterVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutBeforeVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutNowVo;
import org.apache.ibatis.annotations.Param;

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
