package com.qunar.qauction.web.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.qunar.qauction.common.exceptions.ParameterException;
import com.qunar.qauction.common.utils.CookieUtil;
import com.qunar.qauction.common.utils.LogUtils;
import com.qunar.qauction.model.userauction.vo.UserAuctionInAfterVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionInNowVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionOrderFailVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionOrderSuccessVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionOutAfterVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionOutBeforeVo;
import com.qunar.qauction.model.userauction.vo.UserAuctionOutNowVo;
import com.qunar.qauction.service.userauction.UserAucitonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.api.pojo.CodeMessage;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.google.common.base.Preconditions.checkArgument;

/**
*
* Created by yangsongbao on 16-4-18.
*/
@Controller
@RequestMapping("/auctionList")
public class UserAuctionController extends BaseController {

    public static final String userLoginId = "login_id";
    @Resource
    public UserAucitonService userAucitonService;

    /**
     * 查询我参加的拍卖相关信息
     *
     * @return
     */
    @RequestMapping("/my_auction_in")
    @JsonBody
    public Object queryMyAuctionIn(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
                                   @RequestParam(value = "auction_type") String auctionType, HttpServletRequest request)
                                    throws ParameterException {
        Preconditions.checkArgument(currentPage > 0, "pageNum参数错误");
        Preconditions.checkArgument(pageSize > 0, "pageSize参数错误");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(auctionType), "auctionType参数错误");

        String loginId = CookieUtil.getCookieValue(request, userLoginId);

        LogUtils.info("query the auction info user attended");
        if("now".equals(auctionType)){
            UserAuctionInNowVo userAuctionInNowVo = userAucitonService.queryUserAuctionInNow(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionInNowVo);
        }else if("after".equals(auctionType)){
            UserAuctionInAfterVo userAuctionInAfterVo = userAucitonService.queryUserAuctionInAfter(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionInAfterVo);
        }else {
            throw new ParameterException("auctionType参数错误");
        }

    }

    /**
     * 查询我要拍出的物品的相关信息
     *
     * @return
     */
    @RequestMapping("/my_auction_out")
    @JsonBody
    public Object queryMyAuctionOut(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
                                    @RequestParam(value = "auction_type") String auctionType, HttpServletRequest request)
                                    throws ParameterException {
        Preconditions.checkArgument(currentPage > 0, "pageNum参数错误");
        Preconditions.checkArgument(pageSize > 0, "pageSize参数错误");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(auctionType), "auctionType参数错误");

        String loginId = CookieUtil.getCookieValue(request, userLoginId);

        LogUtils.info("query the auction info user want to auction off");
        if("before".equals(auctionType)){
            UserAuctionOutBeforeVo userAuctionOutBeforeVo = userAucitonService.queryUserAuctionOutBefore(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionOutBeforeVo);
        }else if("now".equals(auctionType)){
            UserAuctionOutNowVo userAuctionOutNowVo = userAucitonService.queryUserAuctionOutNow(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionOutNowVo);
        }else if("after".equals(auctionType)){
            UserAuctionOutAfterVo userAuctionOutAfterVo = userAucitonService.queryUserAuctionOutAfter(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionOutAfterVo);
        }else {
            throw new ParameterException("auctionType参数错误");
        }
    }

    /**
     * 查询我的订单的相关信息
     *
     * @return
     */
    @RequestMapping("/my_auction_order")
    @JsonBody
    public Object queryMyAuctionOrder(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "auction_type") String auctionType, HttpServletRequest request)
            throws ParameterException {
        Preconditions.checkArgument(currentPage > 0, "pageNum参数错误");
        Preconditions.checkArgument(pageSize > 0, "pageSize参数错误");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(auctionType), "auctionType参数错误");

        String loginId = CookieUtil.getCookieValue(request, userLoginId);

        LogUtils.info("query the user history auction order info");
        if("success".equals(auctionType)){
            UserAuctionOrderSuccessVo userAuctionOrderSuccessVo = userAucitonService.queryUserAuctionOrderSuccess(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, "查询成功", userAuctionOrderSuccessVo);
        }else if("fail".equals(auctionType)){
            UserAuctionOrderFailVo userAuctionOrderFailVo = userAucitonService.queryUserAuctionOrderFail(currentPage, pageSize, loginId);
            return new JsonV2<>(CodeMessage.OK, " 查询成功",userAuctionOrderFailVo);
        }else {
            throw new ParameterException("auctionType参数错误");
        }
    }

}
