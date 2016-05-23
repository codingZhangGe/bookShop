package com.xupt.bookshop.service.home.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xupt.bookshop.common.datasource.DataSource;
import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.common.utils.beanmapper.OrikaBeanMapper;
import com.xupt.bookshop.model.Category.Category;
import com.xupt.bookshop.dao.HomeDao;
import com.xupt.bookshop.model.Category.CategoryVo;
import com.xupt.bookshop.model.home.BookingPo;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.service.home.HomeService;
import com.xupt.bookshop.service.common.ImgService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public List<Category> queryParentCategory() {

       List<Category> categoryList=  homeDao.querParentCategory();
        return categoryList;

    }

    @Override
    public List<Category> queryAllCategory() {
        return homeDao.queryAllCategory();
    }

    @Override
    public List<CategoryVo> queryAllChildCategory(String parentName) {
        List<CategoryVo> categoryVos = Lists.newArrayList();

        List<Category> categoryList=homeDao.queryAllChildCategory(parentName);
      for(Category category:categoryList){
          CategoryVo categoryVo=new CategoryVo();
          Map<String,List<Category>> childCategories= Maps.newHashMap();
          categoryVo.setCategoryName(category.getCategoryName());
          List<Category> categories=homeDao.queryAllChildCategory(category.getCategoryName());
          childCategories.put(category.getCategoryName(), categories);
          categoryVo.setChildCategory(childCategories);
          categoryVos.add(categoryVo);
      }
return categoryVos;
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
        List<BookingPo> BookingPos=Lists.newArrayList();

        RowBounds rowBounds = new RowBounds(currentPage-1, pageSize);
        Category category=homeDao.queryParentIdByName(categoryName);
        if(category.getParentId()==0){
            //查询二级目录
            List<Category> categories=homeDao.queryAllChildCategory(categoryName);
            //遍历二级目录
            for(Category category1:categories){
                //查出三级目录
                for(Category c:homeDao.queryAllChildCategory(category1.getCategoryName()))
                {
                    //根据三级目录查出图书
                    List<BookingPo> pos=homeDao.queryBookingPoByCategory(c.getCategoryName(),rowBounds);
                    BookingPos.addAll(pos);
                }
            }
            //根据一级目录查询的图书
            BookingPos.addAll(homeDao.queryBookingPoByCategory(categoryName,rowBounds));

        }
       else {
            BookingPos = homeDao.queryBookingPoByCategory(categoryName, rowBounds);
        }
        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return new PageResult<>(homeDao.queryBookPagesByCategory(categoryName),BookingVos);
    }

    @Override
    public PageResult<BookingVo> searchBook(String categoryName, Integer currentPage, Integer pageSize) {
        return null;
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
        List<BookingPo> BookingPos = homeDao.queryBookingPoByStateAndCategory(state,category,rowBounds);

        for (BookingPo po : BookingPos) {

            BookingVo auctioningVo ;
            auctioningVo=orikaBeanMapper.map(po, BookingVo.class);
            auctioningVo.setUrlList(imgService.getFirstPictureUrl(po.getBookId()));
            BookingVos.add(auctioningVo);
        }
        return new PageResult<>(homeDao.queryBookPagesByCategoryAndState(category,state),BookingVos);
    }
}
