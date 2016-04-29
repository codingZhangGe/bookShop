package com.xupt.bookshop.model.login;

/**
 * Created by zhangge on 16-4-24.
 */
public class User {

    private String userName;
    private String password;
    private String tel;
    private String email;

    public void setName(String name) {
        this.userName = name;
    }
    public String getName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
