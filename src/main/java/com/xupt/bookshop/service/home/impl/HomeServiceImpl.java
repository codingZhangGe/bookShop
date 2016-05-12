package com.xupt.bookshop.service.home.impl;

import com.google.common.collect.Lists;
import com.xupt.bookshop.common.datasource.DataSource;
import com.xupt.bookshop.common.utils.PageResult;
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
@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    public HomeDao homeDao;
    @Resource
    public ImgService imgService;

    @Resource
    OrikaBeanMapper orikaBeanMapper;


    @Override
    @DataSource(value = DataSource.slave)
    public List<Category> queryAllCategory() {
        return homeDao.queryAllCategory();
    }
    

    @Override
    @DataSource(value = DataSource.slave)
    public PageResult<BookingVo> queryBookingVo( Integer currentPage, Integer pageSize) {

        List<BookingVo> bookingVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, pageSize);
        List<BookingPo> AuctioningPos = homeDao.queryBookingPo( rowBounds);

        for (BookingPo po : AuctioningPos) {
            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po,BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            auctioningVo.setBookState(po.getBookState());
            bookingVos.add(auctioningVo);
        }
       return new PageResult<>(homeDao.queryBookPages(),bookingVos);
    }

    @Override
    @DataSource(value = DataSource.slave)
    public PageResult<BookingVo> queryItemByCategory(String  categoryName, Integer currentPage, Integer pageSize) {

        List<BookingVo> BookingVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, pageSize);
        List<BookingPo> BookingPos = homeDao.queryBookingPoByCategory(categoryName, rowBounds);

        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return new PageResult<>(homeDao.queryBookPagesByCategory(categoryName),BookingVos);
    }

    @Override
    @DataSource(value = DataSource.slave)
    public int queryBookPages() {
        return homeDao.queryBookPages();
    }

    @Override
    @DataSource(value = DataSource.slave)
    public PageResult<BookingVo> queryItemByState(int state, int currentPage, int pageSize) {
        List<BookingVo> BookingVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, pageSize);
        List<BookingPo> BookingPos = homeDao.queryBookingPoByState(state, rowBounds);

        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return new PageResult<>(homeDao.queryBookPagesByState(state),BookingVos);
    }

    @Override
    public PageResult<BookingVo> queryItemByStateAndCategory(int state, String category, int currentPage, int pageSize) {
        List<BookingVo> BookingVos = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, pageSize);
        List<BookingPo> BookingPos = homeDao.queryBookingPoByStateAndCategory(state,category, rowBounds);

        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return new PageResult<>(homeDao.queryBookPagesByCategoryAndState(category,state),BookingVos);
    }
}
