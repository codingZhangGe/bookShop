package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.bookdetails.BookDetail;
import com.xupt.bookshop.model.bookdetails.AuctionMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图书详情 Created by zhangge on 16-4-18.
 */

@Repository
public interface BookDetailDao {
    /**
     * 查询拍卖详情页面所需要显示的信息
     *
     * @return
     */

    BookDetail queryBookDetail(@Param("bookId")String bookId);


    int updateBrowserCount(@Param("bookId") String bookId);
    int updateBuyCount(@Param("bookId") String bookId);
    int updateSurplus(@Param("bookId") String bookId,@Param("buy") int buy);



}
