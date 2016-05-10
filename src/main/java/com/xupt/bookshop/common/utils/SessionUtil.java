package com.xupt.bookshop.common.utils;


import com.xupt.bookshop.model.login.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangge on 16-4-6.
 */
public class SessionUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(SessionUtil.class);
    //全局session
    private static final ThreadLocal<User> session = new ThreadLocal<User>();

    public SessionUtil() {
        LOGGER.error("[ERROR]: <UserContainer>: Cannot instantiate this class");
        throw new UnsupportedOperationException("不允许实例化此类");
    }

    public static void setUserSession(User user) {
        session.set(user);
    }

    public static User getUserSession() {
        return session.get();
    }

    public static void closeSession() {
        session.remove();
    }
}
