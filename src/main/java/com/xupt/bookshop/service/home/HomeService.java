package com.xupt.bookshop.service.home;

import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.model.common.Category;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: 主页Service
 *
 * @author lingtong.fu
 * @version 2016-04-18 13:02
 */

@Service
public interface HomeService {

    String sayHi(String name);

    /**
     * 查询所有类别
     */
    List<Category> queryAllCategory();

    /**
     * 通过状态分页查询所有最近商品
     */
    PageResult<BookingVo> queryBookingVo( Integer currentPage, Integer pageSize);

    /**
     * 通过类别查询正在竞拍中的物品信息
     */
    PageResult<BookingVo> queryItemByCategory(String  categoryName, Integer currentPage, Integer pageSize);

    /**
     * 查询总数
     * @return 总数
     */
    int queryBookPages();

    PageResult<BookingVo> queryItemByState(int state,int currentPage,int pageSize);
}
