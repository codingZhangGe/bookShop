package com.xupt.bookshop.service.userauction;

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
 * Created by yangsongbao on 16-4-18.
 */
public interface UserAucitonService {

    /**
     * 查询当前登陆用户参加的拍卖中的拍品信息, 该拍卖状态为进行中
     *
     * @param currentPage 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户参加的拍卖中的物品信息
     */
    public UserAuctionInNowVo queryUserAuctionInNow(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                    @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户参加的拍卖的拍品信息, 该拍卖状态为已结束
     *
     * @param currentPage 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户参加的拍卖中的物品信息
     */
    public UserAuctionInAfterVo queryUserAuctionInAfter(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                        @Param("loginId") String loginId);



    /**
     * 查询当前登陆用户要拍卖出去的物品信息, 该拍卖状态为未开始
     *
     * @param currentPage 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户要拍卖出去的物品信息
     */
    public UserAuctionOutBeforeVo queryUserAuctionOutBefore(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                            @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户要拍卖出去的物品信息, 该拍卖状态为进行中
     *
     * @param currentPage 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户要拍卖出去的物品信息
     */
    public UserAuctionOutNowVo queryUserAuctionOutNow(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                      @Param("loginId") String loginId);

    /**
     * 查询当前登陆用户要拍卖出去的物品信息, 该拍卖状态为已结束
     *
     * @param currentPage 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户要拍卖出去的物品信息
     */
    public UserAuctionOutAfterVo queryUserAuctionOutAfter(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                          @Param("loginId") String loginId);

    /**
     * 查询当前登陆用的历史订单, 该订单竞价成功
     *
     * @param offset 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户的历史订单
     */
    public UserAuctionOrderSuccessVo queryUserAuctionOrderSuccess(@Param("currentPage") int offset, @Param("pageSize") int pageSize,

                                                                  @Param("loginId") String loginId);

    /**
     * 查询当前登陆用的历史订单, 该订单竞价失败
     *
     * @param offset 分页信息之偏移量
     * @param pageSize 分页信息之每页数量
     * @param loginId 当前登陆用的qtalk
     * @return 当前登陆用户的历史订单
     */
    public UserAuctionOrderFailVo queryUserAuctionOrderFail(@Param("currentPage") int offset, @Param("pageSize") int pageSize,
                                                            @Param("loginId") String loginId);

}
