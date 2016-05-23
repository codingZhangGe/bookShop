package com.xupt.bookshop.model.common;

import com.sun.javafx.beans.annotations.NonNull;
import com.xupt.bookshop.model.login.validation.Email;
import com.xupt.bookshop.model.order.param.Tel;

/**
 * Created by zhangge on 16-5-23.
 */
public class Contact {
    int id;
    @NonNull
    String username;
    @Email
    String email;
    @Tel
    String tel;
    String message;

    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }



    public void setId(int id) {
        this.id = id;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
