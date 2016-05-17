package com.xupt.bookshop.web.controller;

import com.google.common.base.Strings;
import com.xupt.bookshop.model.ResultOfRequest;
import com.xupt.bookshop.model.bookdetails.param.BookDetailParam;
import com.xupt.bookshop.model.bookdetails.param.AddCategoryParam;
import com.xupt.bookshop.model.bookdetails.vo.BookInfoVo;
import com.xupt.bookshop.model.common.JsonResult;
import com.xupt.bookshop.service.bookdetails.BookDetailService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class BookDetailController extends BaseController {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(BookDetailController.class);
    @Resource
    BookDetailService bookDetailService;


    /**
     * 商品详细信息展示
     * @return
     */
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @ResponseBody
    public Object bookDescription(@Valid BookDetailParam bookDetailParam) {

       logger.info("query book details book id={}",bookDetailParam.getBookId());

        BookInfoVo bookInfoVo = bookDetailService.queryBookDetail(bookDetailParam.getBookId());
        return JsonResult.succ(bookInfoVo);

    }

    /**
     *加入购物车操作
     *@param
     *@return 成功：返回商品id 和现 失败：返回失败信息
     */
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    @ResponseBody
    public Object addCategory(@Valid AddCategoryParam doOrderParam, @CookieValue("login_id") String username)
    {
        checkArgument(!Strings.isNullOrEmpty(username),"username 不能是空");
        ResultOfRequest resultOfRequest ;
        doOrderParam.setUserName(username);
        resultOfRequest =bookDetailService.judgeItemAddCategory(doOrderParam);
        if (!resultOfRequest.getResult()) {
            return new JsonV2<>(resultOfRequest.getCode(), resultOfRequest.getMessage(), null);
        }
        return new JsonV2<>(resultOfRequest.getCode(), resultOfRequest.getMessage(), resultOfRequest.getData());

    }


}
