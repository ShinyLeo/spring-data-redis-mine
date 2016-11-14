package com.shinyleo.spring.model;

import java.io.Serializable;

/**
 * Created by zhugh on 16/11/10.
 */
public class User implements Serializable {

    private String userName;
    private String age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
