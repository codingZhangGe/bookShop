package com.qunar.qauction.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.qunar.qauction.model.userauction.UserAuctionInAfter;
import com.qunar.qauction.model.userauction.UserAuctionInNow;
import com.qunar.qauction.model.userauction.UserAuctionOrderFail;
import com.qunar.qauction.model.userauction.UserAuctionOrderSuccess;
import com.qunar.qauction.model.userauction.UserAuctionOutAfter;
import com.qunar.qauction.model.userauction.UserAuctionOutBefore;
import com.qunar.qauction.model.userauction.UserAuctionOutNow;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */

@Repository
public interface UserAuctionDao {

    /**
     * 查询当前登陆用户参加的拍卖中, 状态为竞拍中的物品信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户参加的拍卖中, 状态为竞拍中的物品信息
     *
     */
    public UserAuctionInNow queryUserAuctionInNow(RowBounds rowBounds, @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户参加的拍卖中, 已经结束竞拍的物品信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户参加的拍卖中, 已经结束竞拍的物品信息
     */
    public UserAuctionInAfter queryUserAuctionInAfter(RowBounds rowBounds, @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户要拍卖出去的物品中, 状态为未开始的物品信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户要拍卖出去的物品中, 状态为未开始的物品信息
     */
    public UserAuctionOutBefore queryUserAuctionOutBefore(RowBounds rowBounds, @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户要拍卖出去的物品中, 状态为竞拍中的物品信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户要拍卖出去的物品中, 状态为竞拍中的物品信息
     */
    public UserAuctionOutNow queryUserAuctionOutNow(RowBounds rowBounds, @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户要拍卖出去的物品中, 状态为已结束的物品信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户要拍卖出去的物品中, 状态为已结束的物品信息
     */
    public UserAuctionOutAfter queryUserAuctionOutAfter(RowBounds rowBounds, @Param("loginId") String loginId);

       /**
     * 查询当前登陆用户的历史成功订单信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户的历史成功订单信息
     */
    public UserAuctionOrderSuccess queryUserAuctionOrderSuccess(RowBounds rowBounds, @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户的历史失败订单信息
     *
     * @param rowBounds 分页信息
     * @param loginId 当前登陆用户的qtalk号
     * @return 当前登陆用户的历史失败订单信息
     */
    public UserAuctionOrderFail queryUserAuctionOrderFail(RowBounds rowBounds, @Param("loginId") String loginId);

}
