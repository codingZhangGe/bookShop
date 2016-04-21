package com.qunar.qauction.service.auctiondetails.impl;


import com.qunar.qauction.dao.AuctionDetailDao;
import com.qunar.qauction.dao.AuctiondynamicItemDao;
import com.qunar.qauction.model.auctiondetails.param.UpdateDynamic;
import com.qunar.qauction.model.common.UnfinishedItemDynamicInfo;
import com.qunar.qauction.model.auctiondetails.vo.AuctionDetail;
import com.qunar.qauction.model.auctiondetails.AuctionOrder;
import com.qunar.qauction.service.auctiondetails.AuctionDetailService;
import com.qunar.qauction.service.common.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import qunar.api.pojo.Money;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 * Created by zhangge on 16-4-18.
 */

@Service("AuctionService")
public class AuctionServiceImpl implements AuctionDetailService{

   private static Logger logger= LoggerFactory.getLogger(AuctionServiceImpl.class);

    @Resource
    AuctionDetailDao auctionDetailDao;
    @Resource ImgService imgService;
    @Resource
    AuctiondynamicItemDao auctiondynamicItemDao;


    /**
     * 查询拍卖品的详细信息
     * @param auctionItemId 拍卖品id
     * @return 返回拍卖品的详细信息
     */
    @Override
    public AuctionDetail queryAuctionDetail(String auctionItemId) {
        AuctionDetail auctionDetail;

        auctionDetail=auctionDetailDao.queryAuctionDetail(auctionItemId);
        if(auctionDetail==null){
            logger.info("商品不存在");
            return null;
        }

        auctionDetail.setUrlList(imgService.getPictureUrl(auctionItemId));
        return auctionDetail;
    }

    /**
     *更新拍卖商品的浏览记录
     * @param itemId 商品id
     * @return 是否更新成功
     */
    @Override
    public boolean updateBrowserCount(String itemId) {
        //此商品是否存在
        if(auctionDetailDao.queryAuctionItem(itemId)==null){
            logger.info("拍品不存在");
            return false;
        }
        //动态信息表不存此商品的记录,第一个进入浏览
        if(auctiondynamicItemDao.queryAuctiondynamicainfoById(itemId)==null){
            UnfinishedItemDynamicInfo unfinishedItemDynamicInfo=new UnfinishedItemDynamicInfo();
            unfinishedItemDynamicInfo.setItemId(itemId);
            unfinishedItemDynamicInfo.setAuctionCount(0); //设置默认值是0
            unfinishedItemDynamicInfo.setBrowseCount(1); //设置默认值是1
            unfinishedItemDynamicInfo.setSubscriptionCount(0);//设置拍卖人数为0
            //此商品的动态表是空，那么就是第一次浏览，当前价格应该是起始价格

            Money currentPrice=auctionDetailDao.queryAuctionItem(itemId).getStartPrice();

            unfinishedItemDynamicInfo.setCurrentPrice(currentPrice);
            auctiondynamicItemDao.insertAuctiondynamicaInfo(unfinishedItemDynamicInfo);
           logger.info("第一次动态记录插入{}",itemId);
        }
        else{

            auctiondynamicItemDao.updateBrowserCount(itemId);
            logger.info("更新商品{}浏览次数", itemId);
        }
        return true;
    }

    /**
     * 创建拍卖订单
     * @param itemId 商品 id
     * @param bidderMoney 拍卖价格
     * @param username 拍卖用户
     * @return 是否成功创建
     */
    @Override
    public boolean createOrder(String itemId,String bidderMoney,String username) {

        Money currentMoney=auctionDetailDao.queryAuctionDetail(itemId).getAuctionPrice();
        //时间没有到的情况，当前价格大于或者等于出价价格，出价失败
        if(currentMoney.getAmount() .compareTo(BigDecimal.valueOf(Double.valueOf(bidderMoney)))>=0){
            logger.info("出价失败，拍卖价格{},当前价格{}",bidderMoney,currentMoney);
            return false;
        }
        AuctionOrder auctionOrder=new AuctionOrder();
        auctionOrder.setItemId(itemId);
        auctionOrder.setAuctionPrice(Money.of(BigDecimal.valueOf(Double.valueOf(bidderMoney))));
        auctionOrder.setBidderQtalk(username);
        auctiondynamicItemDao.createAuctionOrder(auctionOrder);
        //更新拍卖动态信息：竞拍商品价格，目前竞价人，浏览次数，竞拍次数
        UpdateDynamic updateDynamic=new UpdateDynamic();
        updateDynamic.setItemId(itemId);
        updateDynamic.setCurrentMoney(Money.of(BigDecimal.valueOf(Double.valueOf(bidderMoney))));
        updateDynamic.setBidderQtalk(username);
        auctiondynamicItemDao.updateAuctionCountAndPrice(updateDynamic);
        logger.info("创建订单成功，商品{}",itemId);
        return true;
    }
}
