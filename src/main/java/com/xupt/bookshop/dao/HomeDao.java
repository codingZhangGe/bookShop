package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.Category.Category;
import com.xupt.bookshop.model.home.BookingPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: HomeDao
 *
 * @author ge.zhang
 * @version 2016-04-19 14:13
 */
@Repository
public interface HomeDao {
    /**
     * 查询全部分类
     * @return
     */
    List<Category> queryAllCategory();

    /**
     * 查询一级分类
     * @return
     */
    List<Category> querParentCategory();
    List<Category> queryAllChildCategory(@Param("parentId")String parentId);
    Category queryParentIdByName(@Param("categoryName") String category);

    List<BookingPo> queryBookingPo( RowBounds rowBounds);

    List<BookingPo> queryBookingPoByCategory(@Param("categoryName") String categoryName, RowBounds rowBounds);
    List<BookingPo> queryBookingPoByState(@Param("state") Integer state, RowBounds rowBounds);
    List<BookingPo> queryBookingPoByStateAndCategory(@Param("state") Integer state, @Param("categoryName") String categoryName,RowBounds rowBounds);
    List<BookingPo> searchBookingPoByState(@Param("state") Integer state, RowBounds rowBounds);



    int queryBookPages();
    int queryBookPagesByState(@Param("state") Integer state);
    int queryBookPagesByCategory(@Param("categoryName") String categoryName);
    int queryBookPagesByCategoryAndState(@Param("categoryName") String categoryName,@Param("state") Integer state);

}
