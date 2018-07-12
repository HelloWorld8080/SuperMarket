package com.sm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 *   
 *  @ProjectName: springmvc-mybatis 
 *  @Description: 创建中间类RedisCacheTransfer，完成RedisCache.jedisConnectionFactory的静态注入,
 *                静态注入中间类
 *  @author: lisen
 *  @date: 2017/11/8  
 */
public class RedisCacheTransfer {

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
