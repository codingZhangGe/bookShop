package com.xupt.bookshop.web.controller;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.List;
import javax.annotation.Resource;

import com.xupt.bookshop.model.Category.Category;
import com.xupt.bookshop.model.Category.CategoryVo;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.service.home.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: 主页展示所有图书信息Controller
 *
 * @author ge.zhang
 * @version 2016-04-18 10:22
 */

@Controller

public class HomeController {

    Logger logger= LoggerFactory.getLogger(HomeController.class);
    @Resource
    private HomeService homeService;

    /**
     *
     * @return 分页查询所有图书信息
     */
    @ResponseBody
    @RequestMapping(value = "/index/queryBooking", method = RequestMethod.GET)
    public Object queryBooking(  @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                             @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
        logger.info("home of book ");
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
        return JsonResult.succ(homeService.queryBookingVo(currentPage, pageSize));
    }

    /**
     *
     * @return 查询一级类别所有类别
     */
    @ResponseBody
    @RequestMapping(value = "/index/queryParentCategory", method = RequestMethod.GET)
    public Object queryParentCategory() {
        List<Category> categories = homeService.queryParentCategory();

        return JsonResult.succ(categories);
    }

    @ResponseBody
    @RequestMapping(value = "/index/queryCategory", method = RequestMethod.GET)
    public Object queryCategory(@RequestParam(value = "parentName") String parentName) {
        List<CategoryVo> categories = homeService.queryAllChildCategory(parentName);
        return JsonResult.succ(categories);
    }

    /**
     * 分类查询
     * @param category
     * @param currentPage
     * @param pageSize
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "/index/query",method = RequestMethod.GET)
    public  Object queryItemByCategoryAndState(
                                                              @RequestParam(value = "category") String category,
                                                              @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                                              @RequestParam(value = "pageSize", required = false, defaultValue = "3")Integer pageSize){

        if(category!=""){
            return homeService.queryItemByCategory(category,currentPage,pageSize);
        }


        else{
            return homeService.queryBookingVo(currentPage,pageSize);
        }
    }
    /**
     * 搜索
     */
    @ResponseBody
    @RequestMapping(value = "/index/search",method = RequestMethod.GET)
    public Object searchBook(@RequestParam("search") String search){
return JsonResult.succ("搜索成功");
    }

}