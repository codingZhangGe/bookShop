package com.xupt.bookshop.model.login.param;

import com.xupt.bookshop.model.login.validation.Email;
import com.xupt.bookshop.model.login.validation.Password;
import com.xupt.bookshop.model.order.param.Tel;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**用户注册填写参数
 * Created by zhangge on 16-5-10.
 */
public class RegisterParam {
   @NotBlank
    String name;

    @Password
    String password; //密码最少16位
    @Email
    String email;
    @Tel
    String tel;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}