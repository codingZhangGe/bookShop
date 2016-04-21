package com.qunar.qauction.dao;

import com.qunar.qauction.model.auctiondetails.vo.AuctionDetail;
import com.qunar.qauction.model.auctiondetails.AuctionMoney;
import org.springframework.stereotype.Repository;

/**
 * 拍卖详情 Created by zhangge on 16-4-18.
 */

@Repository
public interface AuctionDetailDao {
    /**
     * 查询拍卖详情页面所需要显示的信息
     *
     * @param itemId
     * @return
     */

    AuctionDetail queryAuctionDetail(String itemId);

    AuctionMoney queryAuctionItem(String itemId);

}
