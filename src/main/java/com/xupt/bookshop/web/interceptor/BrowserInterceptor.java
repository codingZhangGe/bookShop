package com.xupt.bookshop.web.interceptor;

import com.xupt.bookshop.service.auctiondetails.AuctionDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统计浏览拍卖商品的人数 当有人进入此controller 的时候就进行拦截器拦截，统计次数 存储到数据库 Created by zhangge on 16-4-18.
 */
public class BrowserInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(BrowserInterceptor.class);
    @Resource
    AuctionDetailService auctionDetailService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 更新当前的商品的浏览人数
        String itemId = request.getParameter("itemId");
        boolean result = auctionDetailService.updateBrowserCount(itemId);
        if (!result) {
            logger.warn("更新失败");
        }
        logger.info("统计页面{}浏览人数", itemId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
