package com.xupt.bookshop.common;

/**
 * @author yunfeng.yang created on 16-4-14
 * @version 1.0
 */
public interface Constants {
    /* 返回码 */ int SUCCEED_CODE = 0; // 成功返回码
    int FAILED_CODE = -1; // 失败返回码
    int BAD_AUTHORITY_CODE = -2; // 权限错误
    int CODE_HAS_OTHER_ORDER = 1; // 该用户存在其他有效的订单
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
    String DEFAULT_LINK = "http:qpai.corp。qunar.com"; // 网页首页
    String DEFAULT_CHARSET_ENCODING = "UTF-8"; //
    String DEFAULT_FROM = "qcarpool";
    String DEFAULT_STRING = "\r\n" + "详情页面             "; // 数据追加

    /* 分页拦截器 */
    String PAGE_PARAM = "pageParam"; // 分页参数名
    String SELECT_SQL_PREFIX = "SELECT"; // 查询语句前缀
    Integer SELECT_START_INDEX = 0; // SELECT的起始位置
    Integer SELECT_END_INDEX = 5; // SELECT的结束位置
    Integer DEFAULT_PAGE_NUMBER = 0; // 默认页码
    Integer DEFAULT_PAGE_SIZE = 20; // 默认页面大小

    /**
     * 拍卖时间最少间隔
     */
    int  BETWEEN_HOUR=1;
}
