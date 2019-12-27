package com.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String userpassword;
    public User(){

    }
    public User(String username,String userpassword){
        this.username=username;
        this.userpassword=userpassword;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
