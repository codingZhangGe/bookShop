package com.xupt.bookshop.dao;

import com.xupt.bookshop.model.login.User;

/**
 * Created by zhangge on 16-4-25.
 */
public interface UserDao {
    /**
     * 按照姓名查找用户，用于在每一个处理前进行用户是否存在检验
     *
     * @param name
     * @return
     */
    public User queryByName(String name);
}
