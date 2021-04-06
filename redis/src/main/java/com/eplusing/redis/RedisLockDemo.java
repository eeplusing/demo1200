package com.eplusing.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Collections;

public class RedisLockDemo {
    private static final String RDEDIS_IP = "192.168.145.129";
    private static final int PORT = 6379;
    private static final int TIMEOUT = 5 * 1000;


    public static void main(String[] args) {
        String key = "eplusingpayOrder";
        String requestId = "2020040620205689";

        RedisLockDemo instance = new RedisLockDemo();

        if (instance.lock(key, requestId)) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("获取锁失败");
        }

    }

    public boolean lock(String key, String requestId) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(config, RDEDIS_IP, PORT, TIMEOUT);
        Jedis jedis = jedisPool.getResource();
        Long start = System.currentTimeMillis();
        try {
            for (; ; ) {
                String lock = jedis.set(key, requestId, "NX", "PX", 20 * 1000);

                //SET命令返回OK ，则证明获取锁成功
                if ("OK".equals(lock)) {
                    return true;
                }
                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                long l = System.currentTimeMillis() - start;
                if (l >= 10 * 1000) {
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            jedis.close();
        }
    }

    /**
     * 解锁
     *
     * @param
     * @return
     */
    public boolean unlock(String key, String requestId) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(config, RDEDIS_IP, PORT, TIMEOUT);
        Jedis jedis = jedisPool.getResource();
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            Object result = jedis.eval(script, Collections.singletonList(key),
                    Collections.singletonList(requestId));
            if ("1".equals(result.toString())) {
                return true;
            }
            return false;
        } finally {
            jedis.close();
        }
    }
}
