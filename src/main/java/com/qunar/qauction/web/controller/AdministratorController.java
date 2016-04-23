package com.qunar.qauction.web.controller;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import javax.annotation.Resource;

import com.qunar.qauction.service.common.ItemTakeOffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import qunar.api.pojo.CodeMessage;
import qunar.api.pojo.json.JsonV2;
import qunar.web.spring.annotation.JsonBody;

import com.google.common.base.Strings;
import com.qunar.qauction.common.Constants;
import com.qunar.qauction.model.admin.Administrator;
import com.qunar.qauction.model.admin.FinishedItemInfoForQuery;
import com.qunar.qauction.model.admin.UnfinishedItemForQuery;
import com.qunar.qauction.model.admin.dto.ResultOfTakeOff;
import com.qunar.qauction.model.common.Category;
import com.qunar.qauction.model.common.MailContent;
import com.qunar.qauction.model.enums.State;
import com.qunar.qauction.service.admin.AdministratorService;
import com.qunar.qauction.service.common.EmailService;

/**
 * @author yunfeng.yang created on 16-4-18
 * @version 1.0
 */
@Controller
@RequestMapping("/administrator")
public class AdministratorController extends BaseController {

    @Resource
    private AdministratorService administratorService;

    @Resource
    private ItemTakeOffService itemTakeOffService;

    @Resource
    private EmailService emailService;

    /**
     * 分页查询完成的竞拍物品信息
     * 
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 完成的竞拍物品信息List
     */
    @JsonBody
    @RequestMapping(value = "/queryFinishedItemList", method = RequestMethod.GET)
    public List<FinishedItemInfoForQuery> queryFinishedItemList(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
        return administratorService.queryFinishedItemList(currentPage, pageSize);
    }

    /**
     * 分页查询正在竞拍物品信息
     * 
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 正在竞拍物品信息List
     */
    @JsonBody
    @RequestMapping(value = "/queryUnfinishedItemList", method = RequestMethod.GET)
    public List<UnfinishedItemForQuery> queryDuringAuctionItemList(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0 && pageSize < 20, "pageSize参数错误");
        return administratorService.queryDuringAuctionItemList(currentPage, pageSize);
    }

    /**
     * 分页查询查询为开始的竞拍物品
     * 
     * @param currentPage 当前页
     * @param pageSize 页面大小
     * @return 未开始的竞拍物品信息List
     */
    @JsonBody
    @RequestMapping(value = "/queryUnStartAuctionItemList", method = RequestMethod.GET)
    public List<UnfinishedItemForQuery> queryUnStartAuctionItemList(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
        return administratorService.queryUnStartItemList(currentPage, pageSize);
    }

    /**
     * 下架尚未完成的竞拍
     * 
     * @param itemId 下架竞拍物品的id
     * @return 当竞拍物品已经下架或者, 拍卖成功, 则下架失败
     */
    @JsonBody
    @RequestMapping(value = "takeOffItems", method = RequestMethod.POST)
    public Object takeOffItems(@RequestParam("itemId") String itemId) {
        checkArgument(!Strings.isNullOrEmpty(itemId), "添加管理员失败, 参数itemId: " + itemId + "错误");
        ResultOfTakeOff resultOfTakeOff = itemTakeOffService.takeOffItem(itemId);
        if (resultOfTakeOff.getResult()) {
            sendEmailWithState(resultOfTakeOff);
            return new JsonV2<String>(CodeMessage.OK, null, "成功下架竞拍物品");
        }
        return new JsonV2<String>(CodeMessage.SYSTEM_ERROR, null, "下架竞拍物品失败, 系统错误, 请稍后重试");
    }

    private void sendEmailWithState(ResultOfTakeOff resultOfTakeOff) {
        if (resultOfTakeOff.getItemState() == State.UN_START_AUCTION) {
            String contentToSeller = "亲爱的小驼, " + resultOfTakeOff.getSellerQtalk() + ", 您的竞拍商品"
                    + resultOfTakeOff.getItemName() + "已经被管理员下架";
            sendEmail(resultOfTakeOff.getSellerQtalk(), contentToSeller);

        }
        if (resultOfTakeOff.getItemState() == State.DURING_AUCTION) {
            String contentToSeller = "亲爱的小驼, " + resultOfTakeOff.getSellerQtalk() + ", 您的竞拍商品"
                    + resultOfTakeOff.getItemName() + "已经被管理员下架";
            String contentToBuyer = "亲爱的小驼, " + resultOfTakeOff.getSellerQtalk() + ",  您正在竞拍的商品"
                    + resultOfTakeOff.getItemName() + "已经被管理员下架";
            sendEmail(resultOfTakeOff.getSellerQtalk(), contentToSeller);
            sendEmail(resultOfTakeOff.getBidderQtalk(), contentToBuyer);
        }
    }

    private void sendEmail(String qtalk, String content) {
        MailContent mailContent = new MailContent();
        mailContent.setContent(content);
        mailContent.setToEmail(qtalk);
        emailService.sendMail(mailContent);
    }

    /**
     * 添加管理员
     * 
     * @param qtalk 新增管理员qtalk
     * @return 成功, 发生异常返回失败
     */
    @JsonBody
    @RequestMapping(value = "/addAdministrator", method = RequestMethod.POST)
    public Object addAdministrator(@RequestParam("qtalk") String qtalk) {
        checkArgument(!Strings.isNullOrEmpty(qtalk), "添加管理员失败, 参数qtalk: " + qtalk + "错误");
        Administrator administrator = new Administrator();
        administrator.setAdministratorQtalk(qtalk);
        administratorService.addAdministrator(administrator);
        return new JsonV2<String>(CodeMessage.OK, null, "成功添加管理员" + qtalk);
    }

    /**
     * 添加类别
     * 
     * @param categoryName 新增类别
     * @return 成功, 发生异常返回失败
     */
    @JsonBody
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public Object addCategory(@RequestParam("categoryName") String categoryName) {
        checkArgument(!Strings.isNullOrEmpty(categoryName), "添加类别失败, categoryName: " + categoryName + "错误");
        Category category = new Category();
        category.setCategoryName(categoryName);
        administratorService.addCategory(category);
        return new JsonV2<String>(CodeMessage.OK, null, "成功添加类别: " + categoryName);
    }

    /**
     * 分页查询类别
     * 
     * @param currentPage 当前页
     * @param pageSize 请求数量
     * @return 类别List
     */
    @JsonBody
    @RequestMapping(value = "/queryAllCategories", method = RequestMethod.GET)
    public List<Category> queryAllCategories(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
        checkArgument(currentPage != null && currentPage > 0, "currentPage参数错误");
        checkArgument(pageSize != null && pageSize > 0, "pageSize参数错误");
        return administratorService.queryAllCategories(currentPage, pageSize);
    }

    /**
     * 处理没有权限登陆的用户
     *
     * @return 用户登录没有管理员权限, 返回错误码
     */
    @JsonBody
    @RequestMapping(value = "/noAuthority", method = RequestMethod.GET)
    public Object noAuthority() {
        return new JsonV2<String>(CodeMessage.SYSTEM_ERROR, null, "对不起, 您没有权限!");
    }

}
