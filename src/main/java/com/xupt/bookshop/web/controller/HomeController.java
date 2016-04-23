package com.xupt.bookshop.web.controller;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xupt.bookshop.model.common.Category;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.service.home.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import qunar.web.spring.annotation.JsonBody;

import com.google.common.collect.Maps;

/**
 * Description: 主页Controller
 *
 * @author lingtong.fu
 * @version 2016-04-18 10:22
 */

@Controller

public class HomeController {

    @Resource private HomeService homeService;

    @RequestMapping("hello") public ModelAndView hello() {
        return new ModelAndView("hello/hello").addObject("name", "world");
    }

    @RequestMapping("ex") public ModelAndView ex() {
        throw new RuntimeException("测试异常");
    }

    @RequestMapping("sayhi") @JsonBody public String sayhi(@RequestParam("name") String name) {
        return homeService.sayHi(name);
    }

    /**
     *
     * @return 分页查询正在竞拍的商品信息
     */
    @JsonBody @RequestMapping(value = "/index/queryAuctioning", method = RequestMethod.GET) public List<BookingVo> queryAuctioningVoByState(
            Integer state, Integer currentPage, Integer pageSize) {
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
        return homeService.queryAuctioningVoByState(state, currentPage, pageSize);
    }

    /**
     *
     * @return 查询所有类别
     */
    @JsonBody @RequestMapping(value = "/index/queryCategory", method = RequestMethod.GET) public Map<Long, String> queryCategory() {
        List<Category> categories = homeService.queryAllCategory();
        Map<Long, String> data = Maps.newHashMap();
        for (Category category : categories) {
            data.put(category.getId(), category.getCategoryName());
        }
        return data;
    }

    /**
     *
     * @return 通过类别查询正在竞拍的物品
     */
    @JsonBody @RequestMapping(value = "/index/queryItemByCategory", method = RequestMethod.GET)
    public List<BookingVo> queryItemByCategory(Integer categoryId, Integer currentPage, Integer pageSize) {
        return homeService.queryItemByCategory(categoryId, currentPage, pageSize);
    }

}