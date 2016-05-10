package com.xupt.bookshop.service.login;

import com.xupt.bookshop.common.datasource.DataSource;
import com.xupt.bookshop.dao.LoginDao;
import com.xupt.bookshop.model.login.User;
import com.xupt.bookshop.model.login.param.RegisterParam;
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
    @DataSource(value = DataSource.slave)
    public User queryByName(String name) {

        logger.info("login query user by name {}",name);
        return loginDao.queryByName(name);
    }

    @Override
    @DataSource(value = DataSource.master)
    public void createUser(RegisterParam registerParamr) {
        logger.info("<createUser> user register" );
        loginDao.addUser(registerParamr);
    }
}
