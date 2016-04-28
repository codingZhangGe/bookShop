package com.xupt.bookshop.service.userauction.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.xupt.bookshop.common.utils.LogUtils;
import com.xupt.bookshop.dao.UserAuctionDao;
import com.xupt.bookshop.model.userauction.UserAuctionOrderFail;
import com.xupt.bookshop.model.userauction.vo.UserAuctionInNowVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOrderFailVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutAfterVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutNowVo;
import com.xupt.bookshop.service.common.ImgService;
import com.xupt.bookshop.model.userauction.UserAuctionInAfter;
import com.xupt.bookshop.model.userauction.UserAuctionInNow;
import com.xupt.bookshop.model.userauction.UserAuctionOrderSuccess;
import com.xupt.bookshop.model.userauction.UserAuctionOutAfter;
import com.xupt.bookshop.model.userauction.UserAuctionOutBefore;
import com.xupt.bookshop.model.userauction.UserAuctionOutNow;
import com.xupt.bookshop.model.userauction.vo.UserAuctionInAfterVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOrderSuccessVo;
import com.xupt.bookshop.model.userauction.vo.UserAuctionOutBeforeVo;
import com.xupt.bookshop.service.userauction.UserAucitonService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * Created by yangsongbao on 16-4-18.
 */
@Service
public class UserAucitonServiceImpl implements UserAucitonService {

    @Resource
    public UserAuctionDao userAuctionDao;

    @Resource
    public ImgService imgService;

    @Override
    public UserAuctionInNowVo queryUserAuctionInNow(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                    @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the auction info user attended which is still in the auction");
        UserAuctionInNow userAuctionInNow = userAuctionDao.queryUserAuctionInNow(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionInNow.getItemId());

        UserAuctionInNowVo userAuctionInNowVo = new UserAuctionInNowVo();
        userAuctionInNowVo.setItemName(userAuctionInNow.getItemName());
        userAuctionInNowVo.setImgUrl(imgUrl);
        userAuctionInNowVo.setCurrentPrice(userAuctionInNow.getCurrentPrice());
        userAuctionInNowVo.setEndTime(userAuctionInNow.getEndTime());
        userAuctionInNowVo.setSellerQtalk(userAuctionInNow.getSellerQtalk());

        return userAuctionInNowVo;
    }

    @Override
    public UserAuctionInAfterVo queryUserAuctionInAfter(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                        @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the auction info user attended which is over");
        UserAuctionInAfter userAuctionInAfter = userAuctionDao.queryUserAuctionInAfter(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionInAfter.getItemId());

        UserAuctionInAfterVo userAuctionInAfterVo = new UserAuctionInAfterVo();
        userAuctionInAfterVo.setItemName(userAuctionInAfter.getItemName());
        userAuctionInAfterVo.setImgUrl(imgUrl);
        userAuctionInAfterVo.setFinalPrice(userAuctionInAfter.getFinalPrice());
        userAuctionInAfterVo.setEndTime(userAuctionInAfter.getEndTime());
        userAuctionInAfterVo.setSellerQtalk(userAuctionInAfter.getSellerQtalk());

        return userAuctionInAfterVo;
    }

    @Override
    public UserAuctionOutBeforeVo queryUserAuctionOutBefore(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                            @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the auction item info user want to auction off which do not start");
        UserAuctionOutBefore userAuctionOutBefore = userAuctionDao.queryUserAuctionOutBefore(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionOutBefore.getItemId());

        UserAuctionOutBeforeVo userAuctionOutBeforeVo = new UserAuctionOutBeforeVo();
        userAuctionOutBeforeVo.setItemName(userAuctionOutBefore.getItemName());
        userAuctionOutBeforeVo.setImgUrl(imgUrl);
        userAuctionOutBeforeVo.setStartPrice(userAuctionOutBefore.getStartPrice());
        userAuctionOutBeforeVo.setStartTime(userAuctionOutBefore.getStartTime());

        return userAuctionOutBeforeVo;
    }

    @Override
    public UserAuctionOutNowVo queryUserAuctionOutNow(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                      @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the auction item info user want to auction off which is still in auction");
        UserAuctionOutNow userAuctionOutNow = userAuctionDao.queryUserAuctionOutNow(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionOutNow.getItemId());

        UserAuctionOutNowVo userAuctionOutNowVo = new UserAuctionOutNowVo();
        userAuctionOutNowVo.setItemName(userAuctionOutNow.getItemName());
        userAuctionOutNowVo.setImgUrl(imgUrl);
        userAuctionOutNowVo.setCurrentPrice(userAuctionOutNow.getCurrentPrice());
        userAuctionOutNowVo.setEndTime(userAuctionOutNow.getEndTime());

        return userAuctionOutNowVo;
    }

    @Override
    public UserAuctionOutAfterVo queryUserAuctionOutAfter(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                          @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the auction item info user want to auction off which is over");
        UserAuctionOutAfter userAuctionOutAfter = userAuctionDao.queryUserAuctionOutAfter(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionOutAfter.getItemId());

        UserAuctionOutAfterVo userAuctionOutAfterVo = new UserAuctionOutAfterVo();
        userAuctionOutAfterVo.setItemName(userAuctionOutAfter.getItemName());
        userAuctionOutAfterVo.setImgUrl(imgUrl);
        userAuctionOutAfterVo.setFinalPrice(userAuctionOutAfter.getFinalPrice());
        userAuctionOutAfterVo.setEndTime(userAuctionOutAfter.getEndTime());
        userAuctionOutAfterVo.setBuyerQtalk(userAuctionOutAfter.getBuyerQtalk());

        return userAuctionOutAfterVo;
    }

    @Override
    public UserAuctionOrderSuccessVo queryUserAuctionOrderSuccess(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                                  @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the user history auction order info");
        UserAuctionOrderSuccess userAuctionOrderSuccess = userAuctionDao.queryUserAuctionOrderSuccess(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionOrderSuccess.getItemId());

        UserAuctionOrderSuccessVo userAuctionOrderSuccessVo = new UserAuctionOrderSuccessVo();
        userAuctionOrderSuccessVo.setItemName(userAuctionOrderSuccess.getItemName());
        userAuctionOrderSuccessVo.setImgUrl(imgUrl);
        userAuctionOrderSuccessVo.setAuctionTime(userAuctionOrderSuccess.getAuctionTime());
        userAuctionOrderSuccessVo.setAuctionPrice(userAuctionOrderSuccess.getAuctionPrice());
        userAuctionOrderSuccessVo.setSellerQtalk(userAuctionOrderSuccess.getSellerQtalk());

        return userAuctionOrderSuccessVo;
    }

    @Override
    public UserAuctionOrderFailVo queryUserAuctionOrderFail(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize,
                                                            @Param("loginId") String loginId) {
        Preconditions.checkNotNull(currentPage > 0, "currentPage参数错误");
        Preconditions.checkNotNull(pageSize > 0, "pageSize");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(loginId), "loginId参数有误");

        RowBounds rowBounds = new RowBounds(currentPage - 1, pageSize);

        LogUtils.info("query the user history auction order info");
        UserAuctionOrderFail userAuctionOrderFail = userAuctionDao.queryUserAuctionOrderFail(rowBounds, loginId);

        String imgUrl = imgService.getFirstPictureUrl(userAuctionOrderFail.getItemId());

        UserAuctionOrderFailVo userAuctionOrderFailVo = new UserAuctionOrderFailVo();
        userAuctionOrderFailVo.setItemName(userAuctionOrderFail.getItemName());
        userAuctionOrderFailVo.setImgUrl(imgUrl);
        userAuctionOrderFailVo.setAuctionTime(userAuctionOrderFail.getAuctionTime());
        userAuctionOrderFailVo.setAuctionPrice(userAuctionOrderFail.getAuctionPrice());
        userAuctionOrderFailVo.setSellerQtalk(userAuctionOrderFail.getSellerQtalk());
        userAuctionOrderFailVo.setBookState(userAuctionOrderFail.getBookState());

        return userAuctionOrderFailVo;
    }
}
