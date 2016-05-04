package com.xupt.bookshop.service.orderService.impl;


import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.dao.OrderDao;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.enums.BookState;
import com.xupt.bookshop.model.order.OrderItem;
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
    @Override
    public ResultOfRequest createOrder(String username,OrderParam orderParam) {
        Preconditions.checkNotNull(orderParam);
        ResultOfRequest resultOfRequest=new ResultOfRequest();
        BigDecimal totalPrice = new BigDecimal(Double.valueOf("0"));
        OrderItem orderItem=new OrderItem();
        //查询出来购物车的信息
        List<CartItem> cartItems = cartDao.queryCartDetail(username);

        for(CartItem cartItem : cartItems){
            if(cartItem.getCurrentPrice()==null)
                totalPrice.add(cartItem.getPrice());
            else{
                totalPrice.add(cartItem.getCurrentPrice());
            }
            orderItem.getBookName().add(cartItem.getBookName());
        }
        orderItem.setTotalPrice(totalPrice);
        orderItem.setAddress(orderParam.getAddress());
        orderItem.setLinkman(orderParam.getLinkman());
        orderItem.setOrderTime(DateTime.now());
        orderItem.setStatus(OrderState.ORDER_NO_PAY);
        //创建订单
        orderDao.createOrder(orderItem);
        //下单成功,清空购物车记录,返回成功状态
        cartDao.removeCartItem(username);
        resultOfRequest.setCode(Constants.DO_ORDER_SUCCESS);
        resultOfRequest.setResult(true);
        resultOfRequest.setMessage("下单成功");
        resultOfRequest.setData(orderItem);
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
     * 选择订单失效的订单id
     * @return
     */
    @Override
    public List<String > selectOrderitemWithTime() {

        List<String> list = orderDao.selectOrderItemWithTime(DateTime.now(), OrderState.ORDER_NO_PAY);

        return list;
    }
}
