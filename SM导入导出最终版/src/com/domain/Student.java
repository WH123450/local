package com.domain;

import java.io.Serializable;

public class Student implements Serializable {
    private String username;
    private String userpassword;
    public Student(){

    }
    public Student(String username,String userpassword){
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
