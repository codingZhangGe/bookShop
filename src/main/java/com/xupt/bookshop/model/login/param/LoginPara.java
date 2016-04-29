package com.xupt.bookshop.model.login.param;

/**
 * Created by zhangge on 16-4-24.
 */

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 登陆需要进行传递两个参数进行封装
 * Created by zhangge on 16-4-5.
 */
public class LoginPara implements Serializable {

    private static final long serialVersionUID = -948144965764779838L;
    @NotEmpty
    @NotNull
    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

