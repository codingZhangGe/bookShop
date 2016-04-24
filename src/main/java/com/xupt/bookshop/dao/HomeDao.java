package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.common.Category;
import com.xupt.bookshop.model.home.BookingPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description: HomeDao
 *
 * @author lingtong.fu
 * @version 2016-04-19 14:13
 */
@Repository
public interface HomeDao {

    List<Category> queryAllCategory();

    List<BookingPo> queryBookingPo( RowBounds rowBounds);

    List<BookingPo> queryBookingPoByCategory(@Param("categoryId") Integer categoryId, RowBounds rowBounds);
}
