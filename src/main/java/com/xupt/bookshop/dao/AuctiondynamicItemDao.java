package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.auctiondetails.AuctionOrder;
import com.xupt.bookshop.model.auctiondetails.param.UpdateDynamic;
import com.xupt.bookshop.model.common.UnfinishedItemDynamicInfo;
import org.springframework.stereotype.Repository;

/**
 * 拍卖商品动态信息操作 浏览人数，拍卖人数，当前价格，拍卖时间 Created by zhangge on 16-4-18.
 */
@Repository
public interface AuctiondynamicItemDao {
    /**
     * 根据商品的id 更新拍卖品的浏览人数信息
     *
     * @param itemId 拍卖品id
     * @return 产生更新的行总数
     */
    public int updateBrowserCount(String itemId);

    /**
     * 根据商品id 更新拍卖品的拍卖人数
     * 
     * @param updateDynamic
     * @return
     */
    public int updateAuctionCountAndPrice(UpdateDynamic updateDynamic);

    /**
     * 根据商品id 查询拍卖品动态表信息
     *
     * @param itemId 拍卖品id
     * @return 拍卖品信息
     */
    public UnfinishedItemDynamicInfo queryAuctiondynamicainfoById(String itemId);

    /**
     * 插入拍卖商品的动态数据
     *
     * @param unfinishedItemDynamicInfo 动态信息
     */
    public void insertAuctiondynamicaInfo(UnfinishedItemDynamicInfo unfinishedItemDynamicInfo);

    void createAuctionOrder(AuctionOrder auctionOrder);

}
