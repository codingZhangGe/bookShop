package com.qunar.qauction.web.controller;

import com.google.common.base.Preconditions;
import com.qunar.qauction.common.exceptions.ParameterException;
import com.qunar.qauction.model.auctiondetails.ReturnMessage;
import com.qunar.qauction.model.auctiondetails.vo.AuctionBidderSuc;
import com.qunar.qauction.service.common.EmailService;
import com.qunar.qauction.model.common.MailContent;
import com.qunar.qauction.common.utils.CookieUtil;
import com.qunar.qauction.model.auctiondetails.vo.AuctionDetail;
import com.qunar.qauction.model.enums.State;
import com.qunar.qauction.service.auctiondetails.AuctionDetailService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.api.pojo.Money;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 展示竞拍详细信息 Created by zhangge on 16-4-17.
 */

@Controller
@RequestMapping("/auction")
public class AuctionDetailController extends BaseController {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(AuctionDetailController.class);
    @Resource
    AuctionDetailService auctionDetailService;
    @Resource
    EmailService emailService;

    /**
     * 商品详细信息展示
     * @param itemId 商品id
     * @return
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @JsonBody
    public JsonV2<String> auctionDescription(@RequestParam("itemId") String itemId) {
        AuctionDetail auctionDetails;
        // 检验参数 id是否为空
        Preconditions.checkArgument(itemId != null && itemId.length() > 0, "商品id 为空");
        // 查询拍卖品的信息详细信息,根据id
        auctionDetails = auctionDetailService.queryAuctionDetail(itemId);

        if (auctionDetails == null) {
            return new JsonV2<>(ReturnMessage.AUCTION_GOODS_NOT_EXIST, "商品显示失败,商品不存在", itemId);
        }
        // 拍卖已经完成
        if ((auctionDetails.getState().getCode()==State.FAILURE_AUCTION.getCode())
                || (auctionDetails.getState().getCode()==State.SUCCESS_AUCTION.getCode())) {
            return new JsonV2<>(ReturnMessage.AUCTION_FINISHED, "商品已经拍卖完成", itemId);
        }
        // 还没有开始的竞拍，详细信息（开始时间,当前价格）
        if (auctionDetails.getState().equals(State.UN_START_AUCTION)) {
            logger.info("{}-----商品竞拍还没有开始", itemId);
            return new JsonV2<>(ReturnMessage.UN_START_AUCTION, "未开始竞拍", auctionDetails.toString());
        }
         //正在进行的拍卖，详细时间（结束时间，当前价格）
        logger.info("拍卖详情页面 ，商品{}", itemId);
        return new JsonV2<>(ReturnMessage.DURING_AUCTION, "开始的竞拍", auctionDetails.toString());
    }

    /**
     * 竞拍操作
     * @param itemId 竞拍商品名称
     * @return 成功：返回竞拍价格和商品id 失败：返回失败信息
     */
    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    @JsonBody
    public JsonV2<String> doAuction(@RequestParam("itemId") String itemId,
            @RequestParam("bidderPrice") String bidderMoney, HttpServletRequest request) throws ParameterException {

        // 检验参数 id是否为空
        Preconditions.checkArgument(itemId != null && itemId.length() > 0, "商品id 为空");
        String username = CookieUtil.getCookieValue(request, "login_id");
        AuctionDetail auctionDetail;
        AuctionBidderSuc auctionBidderSuc=new AuctionBidderSuc();

        auctionDetail = auctionDetailService.queryAuctionDetail(itemId);
        if(auctionDetail==null){
            return new JsonV2<>(ReturnMessage.AUCTION_GOODS_NOT_EXIST, "商品显示失败,商品不存在", itemId);
        }
        // 判断竞拍商品的状态
        //未开始
        if (auctionDetail.getState().getCode()==State.UN_START_AUCTION.getCode()) {
            return new JsonV2<>(ReturnMessage.UN_START_AUCTION, "拍卖还没有开始", itemId);
        }
        // 获取此商品的结束时间进行和当前时间的判断
        DateTime endTime = auctionDetail.getEndTime();
        //拍卖结束
        if (endTime.compareTo(DateTime.now()) <= 0 || ((auctionDetail.getState().getCode()==State.FAILURE_AUCTION.getCode())
                || (auctionDetail.getState().getCode()==State.SUCCESS_AUCTION.getCode()))) {
            logger.info("拍卖结束，当前时间{},结束时间 {}", DateTime.now(), endTime);
            return new JsonV2<>(ReturnMessage.AUCTION_FINISHED, "拍卖结束", itemId);
        }

        boolean result = auctionDetailService.createOrder(itemId, bidderMoney, username);
        if (!result) {
            return new JsonV2<>(ReturnMessage.BIDDER_FAILUER, "加价失败", itemId);
        } else {
            MailContent mailContent = new MailContent();
            mailContent.setContent("你成功竞拍，加价为：" + bidderMoney);
            mailContent.setToEmail(username);
            emailService.sendMail(mailContent);
            auctionBidderSuc.setItemId(itemId);
            auctionBidderSuc.setBidderMoney(Money.of(Double.parseDouble(bidderMoney)));
            return new JsonV2<>(ReturnMessage.BIDDER_SUCCESS, "加价成功", itemId);
        }
    }
}
