package com.xupt.bookshop.web.controller;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.xupt.bookshop.common.exceptions.ParameterException;
import com.xupt.bookshop.common.utils.CookieUtil;
import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.service.userinfo.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
* 用户中心控制层
* Created by ge.zhang on 16-4-18.
*/
@Controller
public class UserInfoController extends BaseController {

    public static final String userLoginId = "login_id";
    @Resource
    public UserInfoService userInfoService;


    /**
     * 查询我的订单根据不同的状态
     *
     * @return
     */
    @RequestMapping("/my_book_order")
    @JsonBody
    public Object queryMyOrderWithState(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,
            @RequestParam(value = "orderType") String orderType, HttpServletRequest request)
            throws ParameterException {
        Preconditions.checkArgument(currentPage > 0, "pageNum参数错误");
        Preconditions.checkArgument(pageSize > 0, "pageSize参数错误");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(orderType), "auctionType参数错误");

        String loginId = CookieUtil.getCookieValue(request, userLoginId);
        PageResult result = userInfoService.queryOrderByState(currentPage, pageSize, loginId, OrderState.byString(orderType));
        if(result==null){
            return JsonResult.fail("查询失败");
        }
        else
            return JsonResult.succ(result);

    }



public Object queryAllOrder(
        @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
        @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize,HttpServletRequest request
) throws ParameterException {
    Preconditions.checkArgument(currentPage > 0, "pageNum参数错误");
    Preconditions.checkArgument(pageSize > 0, "pageSize参数错误");
    String loginId = CookieUtil.getCookieValue(request, userLoginId);
    PageResult result=userInfoService.queryAllOrder(currentPage,pageSize,loginId);
    if(result==null){
        return JsonResult.fail("查询失败");
    }
    else
        return JsonResult.succ(result);
}


}
