package com.shinyleo.spring.service;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by zhugh on 16/11/10.
 */
public interface RedisService {

    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
