package com.yl.beans;

import java.io.Serializable;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/12/14  15:38
 */
public class User implements Serializable{

    private String username;

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
