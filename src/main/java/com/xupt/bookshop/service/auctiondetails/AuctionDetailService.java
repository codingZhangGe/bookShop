package com.xupt.bookshop.service.auctiondetails;

import com.xupt.bookshop.model.auctiondetails.vo.AuctionDetail;

/**
 * 拍卖商品详情
 * Created by zhangge on 16-4-18.
 */
public interface AuctionDetailService {
    /**
     * 查询拍卖详情
     * @param AuctionItemId
     * @return
     */
    AuctionDetail queryAuctionDetail(String AuctionItemId);
    public boolean updateBrowserCount(String itemId);
    public boolean createOrder(String itemId,String bidderMoney,String username);
}
