package com.sm.web;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class test {
    @Autowired
    static JedisPool pool;
    public static void show() {
        System.out.println(pool);
    }
    public static void main(String[] args) {
        show();
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(        jedis.get("test"));
    }
}
