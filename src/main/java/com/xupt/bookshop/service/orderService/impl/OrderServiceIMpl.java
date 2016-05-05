package com.xupt.bookshop.service.orderService.impl;


import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.common.utils.DateTimeUtil;
import com.xupt.bookshop.common.utils.UUIDGenerator;
import com.xupt.bookshop.common.utils.beanmapper.OrikaBeanMapper;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.dao.OrderDao;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.order.OrderItem;
import com.xupt.bookshop.model.order.OrderItemVo;
import com.xupt.bookshop.model.order.param.OrderParam;
import com.xupt.bookshop.service.orderService.OrderService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**订单业务
 * Created by zhangge on 16-4-27.
 */
@Service("OrderService")
public class OrderServiceIMpl implements OrderService {

    @Resource
    OrderDao orderDao;
    @Resource
    CartDao cartDao;
    @Resource
    OrikaBeanMapper orikaBeanMapper;


    @Override
    public ResultOfRequest createOrder(String username,OrderParam orderParam) {
        Preconditions.checkNotNull(orderParam);
        ResultOfRequest resultOfRequest=new ResultOfRequest();
        OrderItem orderItem=new OrderItem();
        orderItem.setOrderId(UUIDGenerator.getUUID());
        //查询出来购物车的信息
        List<CartItem> cartItems = cartDao.queryCartDetail(username);
        BigDecimal totalPrice=new BigDecimal("0");
        for(CartItem cartItem : cartItems){
            if(cartItem.getCurrentPrice()==null)
            {
                totalPrice=totalPrice.add(cartItem.getPrice());
            }
            else{
                totalPrice=totalPrice.add(cartItem.getCurrentPrice());
            }
        }
        orderItem.setTotalPrice(totalPrice);
        orderItem.setAddress(orderParam.getAddress());
        orderItem.setLinkman(orderParam.getLinkman());
        orderItem.setTelphone(orderParam.getTelphone());
        orderItem.setOrderTime(DateTime.now());
        orderItem.setStatus(OrderState.ORDER_NO_PAY);
        orderItem.setCartItems(cartItems);
        //创建订单
        orderDao.createOrders(orderItem);
        orderDao.createOrderItem(orderItem);
        cartDao.updateCategoryItem();
        OrderItemVo orderItemVo=new OrderItemVo();
        orderItemVo=orikaBeanMapper.map(orderItem,OrderItemVo.class);
        orderItemVo.setOrderTime(orderItem.getOrderTime());
        //下单成功,清空购物车记录,返回成功状态
        resultOfRequest.setCode(Constants.DO_ORDER_SUCCESS);
        resultOfRequest.setResult(true);
        resultOfRequest.setMessage("下单成功");
        resultOfRequest.setData( orderItemVo);
        return resultOfRequest;
    }

    @Override
    public OrderItem queryOrderWithUser(String username) {
        return orderDao.queryOrderDetails(username);
    }

    @Override
    public int updateOrderStatus(String OrderId) {
        int count = orderDao.updateOrderStatus(OrderState.OUT_OF_DATE);
        return count;
    }

    /**
     * 选择时间超过付款时间但是还没有付款的订单
     * @return
     */
    @Override
    public List<String > selectOrderitemWithTime() {

        List<String> list = orderDao.selectOrderItemWithTime(DateTime.now(),OrderState.ORDER_NO_PAY);

        return list;
    }
}
