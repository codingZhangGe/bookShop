package com.xupt.bookshop.model.login;

/**
 * Created by zhangge on 16-4-24.
 */
public class User {

    private int id;
    private String name;
    private String password;
    private int state;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
}
