package com.xupt.bookshop.common;

/**
 * @author ge.zhang created on 16-4-14
 * @version 1.0
 */
public interface Constants {
    int BUY_NORMAL_STATE = 0; //正常返回编码
    int FAILED_CODE = -1;   //失败编码
    int BAD_AUTHORITY_CODE = -2; //全选不够
    /**
     * 业务相关返回码
     */
    int NO_ITEM_FOUND_CODE = -3;   //没有此商品
    int DO_ORDER_FAILURE_ = -4;
    int DO_ORDER_SUCCESS = -5;
    int DELETE_CATEGORY_FAIL = -6;
    int DELETE_CATEGORY_SUCC = -7;
    int ADD_CATEGORY_SUCC = -8;
    int Item_Take_Off_State = -9;
    int OUT_OF_STOCK = -10;
    int LESS_NUM_CODE = -11;
    int ADD_CATEGORY_FAIL = -12;
    int FAILURE_CREATE_ORDER_CODE = -13;
    int ADD_CART_NUM_SUCC=-14;

    /**
     * 电话号码正则表达式
     */
    String TELEPHONE_REGEX = "^\\d{11}$";

    /**
     * 登陆页mapping url
     */
    String LOGIN_PAGE = "/login.html";
    String QUSER_COOKIE = "username"; // username cookie

    int TWENTY_THREE = 23;
    int FIFTY_NINE = 59;
    int NINE_NINE_NINE = 999;

    /**
     *
     */
    int DEFAULT_SIZE = 5; // 图片上传最大数量

    /**
     * Cookie相关常量
     */
    String USERCOOKIE = "login_id";

    /**
     * 邮件相关常量
     */
    String DEFAULT_SUBJECT = "您有新的拍卖信息，点击查看"; // 默认发送主题
    String DEFAULT_EMAIL = "@qunar.com";
    String DEFAULT_LINK = "http:qpai.corp.qunar.com"; // 网页首页
    String DEFAULT_CHARSET_ENCODING = "UTF-8"; //
    String DEFAULT_FROM = "qpai@qunar.com";
    String DEFAULT_STRING = "\r\n" + "链接详情页面             "; // 数据追加

    /* 默认分页 */
    String DEFAULT_CURRENT_PAGE = "1";
    String DEFAULT_PAGE_SIZE = "9";
    int MAX_PAGE_SIZE = 20;



}
