package com.xupt.bookshop.service.home;

import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.Category.CategoryVo;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.model.Category.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 主页Service
 *
 * @author ge.zhang
 * @version 2016-04-18 13:02
 */

@Service
public interface HomeService {


    /**
     * 查询所有类别
     */
    List<Category> queryParentCategory();
    List<CategoryVo> queryAllCategory(String parentId);


    /**
     * 通过状态分页查询所有最近商品
     */
    PageResult<BookingVo> queryBookingVo( Integer currentPage, Integer pageSize);

    /**
     * 通过类别查询物品信息
     */
    PageResult<BookingVo> queryItemByCategory(String  categoryName, Integer currentPage, Integer pageSize);

    /**
     * 查询总数
     * @return 总数
     */
    int queryBookPages();

    PageResult<BookingVo> queryItemByState(int state,int currentPage,int pageSize);

    PageResult<BookingVo> queryItemByStateAndCategory(int state,String category,int currentPage,int pageSize);
}
