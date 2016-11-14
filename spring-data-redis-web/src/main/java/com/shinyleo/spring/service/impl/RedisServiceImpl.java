package com.shinyleo.spring.service.impl;

import com.shinyleo.spring.service.RedisService;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by zhugh on 16/11/10.
 */
@Service("redisService")
public class RedisServiceImpl implements RedisService,InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private ShardedJedisPool    shardedJedisPool;

    ShardedJedis shardJedis;
    @Override
    public void afterPropertiesSet() throws Exception {
        try {
           shardJedis = shardedJedisPool.getResource();
        } catch (Exception e) {
            log.error("error:{}", e);
        }
    }

    @Override
    public ShardedJedis getRedisClient() {
        ShardedJedis shardJedisClient = null;
        try {
           shardJedisClient = shardedJedisPool.getResource();
        } catch (Exception e) {
            log.error("error:{}", e);
        }
        return shardJedisClient;
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
    }

}
