package com.xupt.bookshop.service.home;

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
     * 通过状态分页查询所有最近竞拍物品
     * state = 1 : 正在竞拍
     * state = 2 : 即将竞拍
     */
    List<BookingVo> queryBookingVo( Integer currentPage, Integer pageSize);

    /**
     * 通过类别查询正在竞拍中的物品信息
     */
    List<BookingVo> queryItemByCategory(Integer categoryId, Integer currentPage, Integer pageSize);
}
