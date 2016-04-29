package com.xupt.bookshop.common.utils;


import com.xupt.bookshop.model.login.User;

/**
 * Created by zhangge on 16-4-6.
 */
public class SessionUtil {

    //全局session
    private static final ThreadLocal<User> session = new ThreadLocal<User>();

    public SessionUtil() {

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
