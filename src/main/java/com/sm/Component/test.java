package com.sm.Component;

import com.sm.redis.JedisPool;

/**
 * @Auth justinniu
 * @Date 2018/9/19
 * @Desc
 */
public class test {
    public static void main(String[] args) {
         JedisPool jedisPool = new JedisPool();
         jedisPool.getJedis().set("0919", "hhhh");
        System.out.println(jedisPool.getJedis().get("0919"));
    }
}
