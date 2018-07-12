package com.sm.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
public class JedisPool extends redis.clients.jedis.JedisPool {
    String host;
    int port;
    public JedisPool() {
        this.port = 6379;
        this.host = "127.0.0.1";
    }
    public JedisPool(String host, int port) {
        super(host, port);
    }
    public Jedis getJedis() {
        return new Jedis(host, port);
    }
}
