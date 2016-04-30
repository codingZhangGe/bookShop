package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.bookdetails.BookDetail;
import com.xupt.bookshop.model.bookdetails.AuctionMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 拍卖详情 Created by zhangge on 16-4-18.
 */

@Repository
public interface BookDetailDao {
    /**
     * 查询拍卖详情页面所需要显示的信息
     *
     * @param itemId
     * @return
     */

    BookDetail queryBookDetail(String itemId);

    AuctionMoney queryAuctionItem(String itemId);

    int updateBrowserCount(@Param("bookId") String itemId);



}
