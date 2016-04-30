package com.xupt.bookshop.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: 用户信息Container
 *
 * @author lingtong.fu
 * @version 2016-04-18 18:40
 */
public final class UserContainer {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserContainer.class);
    private static ThreadLocal<String> UserSession = new ThreadLocal<>(); // 用户名Session

    private UserContainer() {
        LOGGER.error("[ERROR]: <UserContainer>: Cannot instantiate this class");
        throw new UnsupportedOperationException("不允许实例化此类");
    }

    /**
     * 初始化会话
     */
    public static void initSession(String username) {
        UserSession.set(username);
    }

    /**
     * 获取当前QUser
     */
    public static String getQUser() {
        return UserSession.get();
    }

    /**
     * 关闭会话
     */
    public static void closeSession() {
        UserSession.remove();
    }

}
