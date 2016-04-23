package com.xupt.bookshop.model.auctiondetails;

/**
 * Created by zhangge on 16-4-20.
 */
public interface ReturnMessage {
    int DURING_AUCTION=0; //正在竞拍
    int UN_START_AUCTION=1;//未开始竞拍
    int BIDDER_SUCCESS=2;//加价成功
    int AUCTION_GOODS_NOT_EXIST=-1;//商品不存在
    int AUCTION_FINISHED=-2;//竞拍失败
    int BIDDER_FAILUER=-3;//加价失败

}
