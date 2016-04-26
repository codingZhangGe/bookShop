package com.xupt.bookshop.web.controller;

import com.google.common.base.Strings;
import com.xupt.bookshop.model.bookdetails.dto.ResultOfJudgeAuction;
import com.xupt.bookshop.model.bookdetails.param.BookDetailParam;
import com.xupt.bookshop.model.bookdetails.param.AddCategoryParam;
import com.xupt.bookshop.model.bookdetails.vo.BookInfoVo;
import com.xupt.bookshop.service.auctiondetails.BookDetailService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;
import javax.annotation.Resource;
import javax.validation.Valid;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * 展示竞拍详细信息 Created by zhangge on 16-4-17.
 */

@Controller
@RequestMapping("/bookshop")
public class AuctionDetailController extends BaseController {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(AuctionDetailController.class);
    @Resource
    BookDetailService bookDetailService;


    /**
     * 商品详细信息展示
     * @return
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @JsonBody
    public BookInfoVo bookDescription(@Valid BookDetailParam bookDetailParam) {

       logger.info("query book details book id={}",bookDetailParam.getItemId());
       return bookDetailService.queryBookDetail(bookDetailParam.getItemId());

    }

    /**
     *加入购物车操作
     *@param
     *@return 成功：返回商品id 和现 失败：返回失败信息
     */
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @JsonBody
    public JsonV2<Object> addCategory(@Valid AddCategoryParam doOrderParam, @CookieValue("login_id") String username)
    {
        checkArgument(!Strings.isNullOrEmpty(username),"username 不能是空");
        //TODO 判断图书的状态 如果是可以进行购买的状态 进行购买
        ResultOfJudgeAuction resultOfJudgeAuction=new ResultOfJudgeAuction();
        resultOfJudgeAuction=bookDetailService.judgeItemAddCategory(doOrderParam);
        if (!resultOfJudgeAuction.getResult()) {
            return new JsonV2<>(resultOfJudgeAuction.getCode(), resultOfJudgeAuction.getMessage(), null);
        }
        return new JsonV2<>(resultOfJudgeAuction.getCode(), resultOfJudgeAuction.getMessage(), resultOfJudgeAuction.getData());

    }


    /**
     * 收藏功能
     */



}
