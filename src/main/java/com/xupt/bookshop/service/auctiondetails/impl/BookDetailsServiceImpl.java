package com.xupt.bookshop.service.auctiondetails.impl;


import com.xupt.bookshop.common.Constants;
import com.xupt.bookshop.common.exceptions.NoItemFoundException;
import com.xupt.bookshop.dao.BookDetailDao;
import com.xupt.bookshop.dao.CartDao;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.bookdetails.param.AddCategoryParam;
import com.xupt.bookshop.model.bookdetails.vo.BookInfoVo;
import com.xupt.bookshop.model.bookdetails.BookDetail;
import com.xupt.bookshop.model.cart.CartItem;
import com.xupt.bookshop.model.enums.State;
import com.xupt.bookshop.service.auctiondetails.BookDetailService;
import com.xupt.bookshop.service.common.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 *
 * Created by zhangge on 16-4-18.
 */

@Service("BookDetailsService")
public class BookDetailsServiceImpl implements BookDetailService {

   private static Logger logger= LoggerFactory.getLogger(BookDetailsServiceImpl.class);

    @Resource
    BookDetailDao bookDetailDao;
    @Resource ImgService imgService;
    @Resource
    CartDao cartDao;




    @Override
    public BookInfoVo queryBookDetail(String bookId) {
      logger.info("query book details from database book id is {}",bookId);
        return bookPoToVo(bookDetailDao.queryBookDetail(bookId));

    }

    /**
     *更新商品的浏览记录
     * @param itemId 商品id
     * @return 是否更新成功
     */
    @Override
    public boolean updateBrowserCount(String itemId) {
        int count = bookDetailDao.updateBrowserCount(itemId);
        if (0 == count) {
            logger.warn("Fail to update browser count :itemId = {}", itemId);
            return false;
        }
        logger.info("Succeed to update browser Count :itemId = {}", itemId);
        return true;
    }

    /**
     * 创建拍卖订单
     * @param itemId 商品 id
     * @param bidderMoney 拍卖价格
     * @param username 拍卖用户
     * @return 是否成功创建
     */
    @Override
    public boolean createOrder(String itemId,String bidderMoney,String username) {

      return true;
    }

    @Override
    public ResultOfRequest judgeItemAddCategory(AddCategoryParam doOrderParam) {
        //根据id查询出来信息
        BookDetail bookDetail=bookDetailDao.queryBookDetail(doOrderParam.getItemId());
        //null
        if(bookDetail==null){
            ResultOfRequest resultOfRequest = new ResultOfRequest();
            resultOfRequest.setResult(false);
            resultOfRequest.setCode(Constants.NO_ITEM_FOUND_CODE);
            resultOfRequest.setMessage("竞拍物品不存在或者已经下架, itemId = " + doOrderParam.getItemId());
            return resultOfRequest;
        }
        //no null 检查传递进来的购买数量和此商品的状态是否正确
        return judgeItemBookLegal(bookDetail,doOrderParam);
    }


    private ResultOfRequest judgeItemBookLegal(BookDetail bookDetail,AddCategoryParam addCategoryParam){

        ResultOfRequest resultOfRequest = judgeItemBookState(bookDetail);
        //判断图书状态是否合法
        if (!resultOfRequest.getResult()) {
            return resultOfRequest;
        }

        // 判断提交的购买数量是否合法
        resultOfRequest = judgebuyNum(addCategoryParam,bookDetail);
        if (!resultOfRequest.getResult()) {
            return resultOfRequest;
        }

        //TODO  判断购买者是否合法，商铺店家不能购买自己的东西


        //购物车信息： 商品名称 价格 折扣价 购买数量 商铺
        return createCategoryWithBookItem(bookDetail, addCategoryParam);
    }

    private ResultOfRequest createCategoryWithBookItem(BookDetail bookDetail,AddCategoryParam addCategoryParam){

       CartItem cartItem =new CartItem();
      cartItem.setBookName(bookDetail.getBookName());
        cartItem.setUserName(addCategoryParam.getCurrentBidderQtalk());
        cartItem.setBookID(bookDetail.getBookId());
        cartItem.setCurrentPrice(bookDetail.getCurrentPrice());
        cartItem.setBuyNum(addCategoryParam.getBuyNumber());
        cartItem.setPrice(bookDetail.getPrice());

        //TODO 返回数据
        ResultOfRequest<CartItem> resultOfRequest =new ResultOfRequest<>();
        resultOfRequest.setResult(true);
        resultOfRequest.setCode(Constants.ADD_CATEGORY_SUCC);
        resultOfRequest.setMessage("添加购物车成功");
        resultOfRequest.setData(cartItem);
        //TODO 插入数据库 用户登陆在购物车中插入一条记录，生成购物车id,每添加一条购物车信息，给购物车详情里面加入，根据用户id 插入
        cartDao.insertCategoryitem(cartItem);
        return resultOfRequest;
    }



    private ResultOfRequest judgeItemBookState(BookDetail bookDetail) {
        ResultOfRequest resultOfRequest = new ResultOfRequest();
        // 判断竞拍物品状态
        State state = bookDetail.getState();
        String itemId = bookDetail.getBookId();
        //无货
        if (State.OUT_OF_STOCK == state || bookDetail.getSurplus()< 0) {
            resultOfRequest.setResult(false);
            resultOfRequest.setCode(Constants.OUT_OF_STOCK);
            resultOfRequest.setMessage("商品无货");
            logger.warn("This book is out of stock itemId = {}", itemId);
            return resultOfRequest;
        }
        //下架
        if (State.UNDER_CARRIAGE== state) {
            resultOfRequest.setResult(false);
            resultOfRequest.setCode(Constants.Item_Take_Off_State);
            resultOfRequest.setMessage("商品已经下架" + itemId);
            logger.warn("Item has been taken off when add cart , itemId = {}", itemId);
            return resultOfRequest;
        }
        resultOfRequest.setResult(true);
        return resultOfRequest;
    }


    private ResultOfRequest judgebuyNum(AddCategoryParam addCategoryParam,BookDetail bookDetail) {
        ResultOfRequest resultOfRequest = new ResultOfRequest();
        // 判断购买的数量是不是高于剩余数量
        int buyNum = addCategoryParam.getBuyNumber();
        int surplusNum = bookDetail.getSurplus();
        if (buyNum>surplusNum) {
            resultOfRequest.setResult(false);
            resultOfRequest.setCode(Constants.LESS_NUM_CODE);
            resultOfRequest.setMessage("库存不够!");
            logger.warn("buy count is bigger  itemId {}", bookDetail.getBookId());
            return resultOfRequest;
        }
        resultOfRequest.setResult(true);
        return resultOfRequest;
    }


    private BookInfoVo dealWithBookItemDetails(String itemId) throws Exception {
        BookDetail bookDetail = bookDetailDao.queryBookDetail(itemId);
        if (null == bookDetail) {
            logger.warn("[WARN]: No item found when query details, itemId = {}", itemId);
            throw new NoItemFoundException("[WARN]: No item found when query details, itemId = " + itemId);
        }
        return bookPoToVo(bookDetail);
    }


    public BookInfoVo bookPoToVo(BookDetail bookDetail){
        BookInfoVo bookInfoVo=new BookInfoVo();
        return bookInfoVo;
    }
}
