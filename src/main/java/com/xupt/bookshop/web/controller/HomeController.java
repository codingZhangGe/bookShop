package com.xupt.bookshop.web.controller;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.bookdetails.vo.BookInfoVo;
import com.xupt.bookshop.model.common.Category;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.home.BookingVo;
import com.xupt.bookshop.service.home.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qunar.api.pojo.CodeMessage;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;
import com.google.common.collect.Maps;

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
     * @return 查询所有类别
     */
    @ResponseBody
    @RequestMapping(value = "/index/queryCategory", method = RequestMethod.GET)
    public Object queryCategory() {
        List<Category> categories = homeService.queryAllCategory();

        return JsonResult.succ(categories);
    }

//    /**
//     *
//     * @return 通过类别查询图书信息
//     */
//    @JsonBody
//    @RequestMapping(value = "/index/queryItemByCategory", method = RequestMethod.GET)
//    public PageResult<BookingVo> queryItemByCategory(   @RequestParam(value = "categoryName", required = false, defaultValue = "1") String  categoryName,
//                                                  @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
//                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
//
//        checkArgument(categoryName != null && categoryName.length() > 0, "categoryId参数错误");
//        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
//        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
//        return homeService.queryItemByCategory(categoryName, currentPage, pageSize);
//    }
//
//
//    @JsonBody
//    @RequestMapping(value = "/index/queryItemByState",method = RequestMethod.GET)
//    public PageResult<BookingVo> queryItemByState(  @RequestParam(value = "state", required = false, defaultValue = "1") Integer state,
//                                                    @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
//                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize){
//
//        checkArgument(state != null && state > 0, "state参数错误");
//        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
//        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
//
//        return homeService.queryItemByState(state,currentPage,pageSize);
//
//    }



    @ResponseBody
    @RequestMapping(value = "/index/query",method = RequestMethod.GET)
    public  Object queryItemByCategoryAndState(@RequestParam(value = "state") String state,
                                                              @RequestParam(value = "category") String category,
                                                              @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
                                                              @RequestParam(value = "pageSize", required = false, defaultValue = "3")Integer pageSize){

        if(category!=""&&(state==null||state.length()==0)){
            return homeService.queryItemByCategory(category,currentPage,pageSize);

        }
        else if(state!=""&&(category==null||category.length()==0)){
            return homeService.queryItemByState(BookState.byString(state).getCode(), currentPage, pageSize);
        }
        else if(state!=""&&category!=""){
            return  homeService.queryItemByStateAndCategory(BookState.byString(state).getCode(),category,currentPage,pageSize);
        }
        else{
            return homeService.queryBookingVo(currentPage,pageSize);
        }
    }
}