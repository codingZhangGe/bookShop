package com.xupt.bookshop.service.home.impl;

import com.google.common.collect.Lists;
import com.xupt.bookshop.common.utils.beanmapper.BeanMapper;
import com.xupt.bookshop.common.utils.beanmapper.OrikaBeanMapper;
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
 * 主页详细信息展示
 * service
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    public HomeDao homeDao;
    @Resource
    public ImgService imgService;

    @Resource
    OrikaBeanMapper orikaBeanMapper;

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
    public List<BookingVo> queryBookingVo( Integer currentPage, Integer pageSize) {

        List<BookingVo> AuctioningVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<BookingPo> AuctioningPos = homeDao.queryBookingPo( rowBounds);

        for (BookingPo po : AuctioningPos) {
            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po,BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));

            AuctioningVos.add(auctioningVo);
        }
        return AuctioningVos;
    }

    @Override public List<BookingVo> queryItemByCategory(Integer categoryId, Integer currentPage, Integer pageSize) {

        List<BookingVo> BookingVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage, pageSize);
        List<BookingPo> BookingPos = homeDao.queryBookingPoByCategory(categoryId, rowBounds);

        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return BookingVos;
    }
}
