package com.qunar.qauction.service.home.impl;

import com.google.common.collect.Lists;
import com.qunar.qauction.model.common.Category;
import com.qunar.qauction.dao.HomeDao;
import com.qunar.qauction.model.home.AuctioningPo;
import com.qunar.qauction.model.home.AuctioningVo;
import com.qunar.qauction.service.home.HomeService;
import com.qunar.qauction.service.common.ImgService;
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
    public List<AuctioningVo> queryAuctioningVoByState(Integer state, Integer currentPage, Integer pageSize) {

        List<AuctioningVo> AuctioningVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<AuctioningPo> AuctioningPos = homeDao.queryAuctioningPoByState(state, rowBounds);

        for (AuctioningPo po : AuctioningPos) {

            AuctioningVo auctioningVo = new AuctioningVo();
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

    @Override public List<AuctioningVo> queryItemByCategory(Integer categoryId, Integer currentPage, Integer pageSize) {

        List<AuctioningVo> AuctioningVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<AuctioningPo> AuctioningPos = homeDao.queryAuctioningPoByCategoryId(categoryId, rowBounds);

        for (AuctioningPo po : AuctioningPos) {

            AuctioningVo auctioningVo = new AuctioningVo();
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
