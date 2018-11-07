package com.sm.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
@Primary
public class JedisPool extends redis.clients.jedis.JedisPool {
    static String  host = "127.0.0.1";
    static int port = 6379;
    public JedisPool() {
        this.port = 6379;
        this.host = "127.0.0.1";
    }
    public JedisPool(String host, int port) {
        super(host, port);
    }
    public static Jedis getJedis() {
        return new Jedis(host, port);
    }
}
