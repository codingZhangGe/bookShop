package com.xupt.bookshop.service.login;

import com.xupt.bookshop.model.login.User;
import com.xupt.bookshop.model.login.param.RegisterParam;

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

    public  String  createUser(RegisterParam registerParamr);

}
