package com.xupt.bookshop.service.auctiondetails;


import com.xupt.bookshop.model.bookdetails.dto.ResultOfJudgeAuction;
import com.xupt.bookshop.model.bookdetails.param.AddCategoryParam;
import com.xupt.bookshop.model.bookdetails.vo.BookInfoVo;

/**
 * 拍卖商品详情
 * Created by zhangge on 16-4-18.
 */
public interface BookDetailService {
    /**
     * 查询拍卖详情
     * @param AuctionItemId
     * @return
     */
    BookInfoVo queryBookDetail(String AuctionItemId);

    /**
     * 更新此图书的浏览信息
     * @param itemId
     * @return
     */
    public boolean updateBrowserCount(String itemId);
    public boolean createOrder(String itemId,String bidderMoney,String username);
    /**
     * 判断此次购买是否正确
     */
    ResultOfJudgeAuction judgeItemAddCategory(AddCategoryParam doOrderParam);
}
