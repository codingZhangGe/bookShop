package com.xupt.bookshop.service.login;

import com.xupt.bookshop.dao.UserDao;
import com.xupt.bookshop.model.login.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangge on 16-4-25.
 */
@Service("LoginService")
public class LoginServiceImpl  implements LoginService {

    @Resource
    UserDao userDao;
    @Override
    public User queryByName(String name) {
        return userDao.queryByName(name);
    }
}
