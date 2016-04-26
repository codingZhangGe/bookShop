package com.xupt.bookshop.service.login;

import com.xupt.bookshop.model.login.User;

/**
 * Created by zhangge on 16-4-25.
 */
public interface LoginService {
    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    public User queryByName(String name);
}
