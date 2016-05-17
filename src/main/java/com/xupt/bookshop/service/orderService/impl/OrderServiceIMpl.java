package com.xupt.bookshop.service.orderService.impl;


import com.google.common.base.Preconditions;
import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.common.datasource.DataSource;
import com.xupt.bookshop.common.utils.UUIDGenerator;
import com.xupt.bookshop.common.utils.beanmapper.OrikaBeanMapper;
import com.xupt.bookshop.dao.BookDetailDao;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.dao.OrderDao;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.OrderState;
import com.xupt.bookshop.model.order.Orders;
import com.xupt.bookshop.model.order.OrdersVo;
import com.xupt.bookshop.model.order.param.OrderParam;
import com.xupt.bookshop.service.orderService.OrderService;
import org.apache.ibatis.session.RowBounds;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    BookDetailDao bookDetailDao;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    @DataSource(value = DataSource.master)
    public ResultOfRequest createOrder(String username,OrderParam orderParam) {
        Preconditions.checkNotNull(orderParam);
        ResultOfRequest resultOfRequest=new ResultOfRequest();
        Orders orders =new Orders();
        orders.setOrderId(UUIDGenerator.getUUID());
        //查询出来购物车的信息
        List<CartItem> cartItems = cartDao.queryCartDetail(username);
        BigDecimal totalPrice=new BigDecimal("0");
        for(CartItem cartItem : cartItems){
            if(cartItem.getCurrentPrice()==null)
            {
                totalPrice=totalPrice.add(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getBuyNum())));
            }
            else{
                totalPrice=totalPrice.add(cartItem.getCurrentPrice().multiply(BigDecimal.valueOf(cartItem.getBuyNum())));
            }
        }
        orders.setUsername(username);
        orders.setTotalPrice(totalPrice);
        orders.setAddress(orderParam.getAddress());
        orders.setLinkman(orderParam.getLinkman());
        orders.setTelphone(orderParam.getTelphone());
        orders.setOrderTime(DateTime.now());
        orders.setStatus(OrderState.ORDER_NO_PAY);
        orders.setCartItems(cartItems);
        //创建订单
        orderDao.createOrders(orders);
        orderDao.createOrderItem(orders);
        cartDao.updateCategoryItem();
        OrdersVo ordersVo =new OrdersVo();
        ordersVo =orikaBeanMapper.map(orders,OrdersVo.class);
        ordersVo.setOrderTime(orders.getOrderTime());
        //下单成功,更新商品的购买次数和商品的剩余数量
        for(CartItem cartItem: orders.getCartItems()) {
            bookDetailDao.updateBuyCount(cartItem.getBookId());
            bookDetailDao.updateSurplus(cartItem.getBookId(),cartItem.getBuyNum());
        }
        //下单成功增加订单总金额数据
        orderDao.insertTotalPrice(orders.getTotalPrice());
        //下单成功,清空购物车记录,返回成功状态
        resultOfRequest.setCode(Constants.DO_ORDER_SUCCESS);
        resultOfRequest.setResult(true);
        resultOfRequest.setMessage("下单成功");
        resultOfRequest.setData(ordersVo);
        return resultOfRequest;
    }

    @Override
    @DataSource(value = DataSource.slave)
    public List<Orders> queryOrderWithUser(int currentPage,int pageSize, String username) {
        RowBounds rowBounds=new RowBounds(currentPage-1,pageSize);
        return orderDao.queryOrderDetails(rowBounds,username);
    }

    @Override
    @DataSource(value = DataSource.master)
    public int updateOrderStatus(String OrderId) {
        int count = orderDao.updateOrderStatus(OrderState.OUT_OF_DATE);
        return count;
    }

    /**
     * 选择时间超过付款时间但是还没有付款的订单
     * @return
     */
    @Override
    @DataSource(value = DataSource.slave)
    public List<String > selectOrderitemWithTime() {

        List<String> list = orderDao.selectOrderItemWithTime(DateTime.now(),OrderState.ORDER_NO_PAY);

        return list;
    }
}
