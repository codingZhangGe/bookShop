package com.xupt.bookshop.service.login;

import com.xupt.bookshop.dao.LoginDao;
import com.xupt.bookshop.model.login.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangge on 16-4-25.
 */
@Service("LoginService")
public class LoginServiceImpl  implements LoginService {

    Logger logger= LoggerFactory.getLogger(LoginServiceImpl.class);
    @Resource
    LoginDao loginDao;
    @Override
    public User queryByName(String name) {

        logger.info(loginDao.queryByName(name).getName());
        return loginDao.queryByName(name);
    }
}
