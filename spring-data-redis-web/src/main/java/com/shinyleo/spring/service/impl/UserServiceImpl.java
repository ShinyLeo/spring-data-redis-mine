package com.shinyleo.spring.service.impl;

import com.shinyleo.spring.model.User;
import com.shinyleo.spring.redis.RedisClient;
import com.shinyleo.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhugh on 16/11/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "redisClient")
    RedisClient redisClient;

    @Override
    public void save(String key, User value) {
        redisClient.setObject(key,value);
    }

    @Override
    public User getUser(String key) {
        return (User) redisClient.getObject(key);
    }
}
