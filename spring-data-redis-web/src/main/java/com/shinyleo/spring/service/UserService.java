package com.shinyleo.spring.service;

import com.shinyleo.spring.model.User;
/**
 * Created by zhugh on 16/11/10.
 */
public interface UserService {

    public void save(String key,User value);

    public User getUser(String key);

}
