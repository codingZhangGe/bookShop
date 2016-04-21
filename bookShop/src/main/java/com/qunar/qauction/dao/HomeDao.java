package com.qunar.qauction.dao;

import com.qunar.qauction.model.common.Category;
import com.qunar.qauction.model.home.AuctioningPo;
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

    List<AuctioningPo> queryAuctioningPoByState(@Param("state") Integer state, RowBounds rowBounds);

    List<AuctioningPo> queryAuctioningPoByCategoryId(@Param("categoryId") Integer categoryId, RowBounds rowBounds);
}
