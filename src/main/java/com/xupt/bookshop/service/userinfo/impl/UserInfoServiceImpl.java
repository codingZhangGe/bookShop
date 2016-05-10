package com.xupt.bookshop.service.userinfo.impl;

import com.google.common.collect.Lists;
import com.xupt.bookshop.common.utils.PageResult;
import com.xupt.bookshop.common.utils.beanmapper.OrikaBeanMapper;
import com.xupt.bookshop.dao.OrderDao;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.OrderItemVo;
import com.xupt.bookshop.service.common.ImgService;

import com.xupt.bookshop.service.userinfo.UserInfoService;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by ge.zhang on 16-4-18.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
 public OrderDao orderDao;

    @Resource
    public ImgService imgService;

    @Resource
    OrikaBeanMapper orikaBeanMapper;

    @Override
    public PageResult queryOrderByState(Integer currentPage,Integer PageSize,String username, OrderState orderState) {

        List<OrderItemVo> orderItemVoList = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, PageSize);
        List<OrderItem> orderItems = orderDao.queryOrderByState(rowBounds, username, orderState.getCode());

        for (OrderItem po : orderItems) {

            OrderItemVo orderVo ;
            orderVo=orikaBeanMapper.map(po, OrderItemVo.class);

            orderItemVoList.add(orderVo);
        }
    return new PageResult(orderDao.queryOrderPagesWithState(username,orderState.getCode()),orderItemVoList);
    }

    @Override
    public PageResult queryAllOrder(Integer currentPage,Integer PageSize,String username) {
        List<OrderItemVo> orderItemVoList = Lists.newArrayList();
        RowBounds rowBounds = new RowBounds(currentPage-1, PageSize);
        List<OrderItem> orderItems=orderDao.queryOrderDetails(rowBounds,username);

        for (OrderItem po : orderItems) {

            OrderItemVo orderVo ;
            orderVo=orikaBeanMapper.map(po, OrderItemVo.class);
            orderItemVoList.add(orderVo);
        }
        return new PageResult(orderDao.queryOrderPages(username),orderItemVoList);
    }
}
