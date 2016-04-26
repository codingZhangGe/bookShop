package com.xupt.bookshop.common;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public interface Constants {
    int AUCTION_NORMAL_STATE = 0;
    int FAILED_CODE = -1;
    int BAD_AUTHORITY_CODE = -2;
    /**
     * 竞拍相关返回码
     */
    int NO_ITEM_FOUND_CODE = -3;
    int AUCTION_FINISHED_CODE = -4;
    int UN_START_AUCTION_CODE = -5;
    int BIDDER_FAILURE_CODE = -6;
    int SAME_BIDDER_CODE = -7;
    int ADD_CATEGORY_SUCC = -8;
    int Item_Take_Off_State = -9;
    int OUT_OF_STOCK = -10;
    int LESS_NUM_CODE = -11;
    int FAILURE_UPDATE_CODE = -12;
    int FAILURE_CREATE_ORDER_CODE = -13;

    /**
     * 电话号码正则表达式
     */
    String TELEPHONE_REGEX = "^\\d{11}$";

    /**
     * 登陆页mapping url
     */
    String LOGIN_PAGE = "/login.html";
    String QUSER_COOKIE = "QUser"; // QUser cookie

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
    String QTALK = "login_id";

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

    /**
     * 拍卖时间最少间隔（以小计算)
     */
    int BETWEEN_HOUR = 1;

    /**
     * 默认qtalk配置
     */
    String DEFAULT_QTALK_BODY = "Body";
    String DEFAULT_QTALK_TO = "To";
    String DEFAULT_QTALK_USER = "User";
    String DEFAULT_QTALK_FROM = "From";
    String DEFAULT_QTALK = "qpai";
    String DEFAULT_QTALK_URL = "http://qtapi.corp.qunar.com/";
    // String DEFAULT_QTALK_URL ="http://192.168.235.72:10056/";
    String DEFAULT_SEND_URL = DEFAULT_QTALK_URL + "sendmessage";

    /**
     * velocity模板信息
     */
    String DEFAULT_START_TEMPLATE = "templates/AuctionStart.vm";
    String DEFAULT_END_TEMPLATE = "templates/AuctionStop.vm";
    String DEFAULT_STEP_TEMPLATE_SELLER = "templates/AuctionStepSeller.vm";
    String DEFAULT_STEP_TEMPLATE_BUGGER="templates/AuctionStepBuyer.vm";


}
