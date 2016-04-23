package com.xupt.bookshop.service.home.impl;

import com.google.common.collect.Lists;
import com.xupt.bookshop.model.common.Category;
import com.xupt.bookshop.dao.HomeDao;
import com.xupt.bookshop.model.home.BookingPo;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.service.home.HomeService;
import com.xupt.bookshop.service.common.ImgService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 主页ServiceImpl
 *
 * @author lingtong.fu
 * @version 2016-04-18 13:02
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    public HomeDao homeDao;
    @Resource
    public ImgService imgService;

    @Override
    public String sayHi(String name) {

        Assert.hasText(name, "名字不能为空");

        return "Hello, " + name;
    }

    @Override
    public List<Category> queryAllCategory() {
        return homeDao.queryAllCategory();
    }
    

    @Override
    public List<BookingVo> queryAuctioningVo( Integer currentPage, Integer pageSize) {

        List<BookingVo> AuctioningVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<BookingPo> AuctioningPos = homeDao.queryAuctioningPo( rowBounds);

        for (BookingPo po : AuctioningPos) {

            BookingVo auctioningVo = new BookingVo();
            auctioningVo.setBookId(po.getBookId());
            auctioningVo.setBookName(po.getBookName());
            auctioningVo.setCategoryId(po.getCategoryId());
            auctioningVo.setDiscount(po.getDiscount());
            auctioningVo.setBrowseCount(po.getBrowseCount());
            auctioningVo.setBuyCount(po.getBuyCount());
            auctioningVo.setPrice(po.getPrice());
            auctioningVo.setCurrentPrice(po.getCurrentPrice());
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));

            AuctioningVos.add(auctioningVo);
        }
        return AuctioningVos;
    }

    @Override public List<BookingVo> queryItemByCategory(Integer categoryId, Integer currentPage, Integer pageSize) {

        List<BookingVo> AuctioningVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<BookingPo> AuctioningPos = homeDao.queryAuctioningPoByCategoryId(categoryId, rowBounds);

        for (BookingPo po : AuctioningPos) {

            BookingVo auctioningVo = new BookingVo();
            auctioningVo.setItemId(po.getItemId());
            auctioningVo.setItemName(po.getItemName());
            auctioningVo.setStartTime(po.getStartTime());
            auctioningVo.setEndTime(po.getEndTime());
            auctioningVo.setBrowseCount(po.getBrowseCount());
            auctioningVo.setAuctionCount(po.getAuctionCount());
            auctioningVo.setSubscriptionCount(po.getSubscriptionCount());
            auctioningVo.setStartPrice(po.getStartPrice());
            auctioningVo.setStepPrice(po.getStepPrice());
            auctioningVo.setCurrentPrice(po.getCurrentPrice());
            auctioningVo.setCategoryId(po.getCategoryId());
            auctioningVo.setItemPictureURL(imgService.getFirstPictureUrl(po.getItemId()));

            AuctioningVos.add(auctioningVo);
        }
        return AuctioningVos;
    }
}
