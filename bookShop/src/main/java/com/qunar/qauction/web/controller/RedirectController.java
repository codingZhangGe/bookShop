package com.qunar.qauction.web.controller;

import com.qunar.qauction.common.Constants;
import com.qunar.qauction.model.common.ItemModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import qunar.web.spring.annotation.JsonBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yunfeng.yang created on 16-4-17
 * @version 1.0
 */
@Controller
@RequestMapping("/redirect")
public class RedirectController extends BaseController {
    /**
     * 登陆页面
     */
    @RequestMapping(value = "/index")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect(Constants.LOGIN_PAGE);
    }

    /**
     * 登陆页面
     */
    @RequestMapping(value = Constants.LOGIN_PAGE)
    public String login() {
        return "login";
    }

    /**
     * 查看商品的详细信息
     */
    @JsonBody
    @RequestMapping(value = "/detailsForItem")
    public ItemModel detailsForItems(String itemId) {
        // TODO

        return new ItemModel();
    }

    // TODO
    // 添加返回首页, 我的拍卖等等
}
