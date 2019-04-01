package com.john.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 获取分布式锁的工具类， 下面的第二个链接讲了错误示例， 在第一个里面出现。 可见看别人的文章需要去分析。
 * https://juejin.im/entry/5a502ac2518825732b19a595
 * https://juejin.im/entry/59f7bbde5188252946502fed
 */
public class RedisLockTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        /**
         * 1. lockKey, 互斥信号,谁能往redis设置这个key即为获取到锁
         * 2. requestid，线程id，可以使用uuid来生成，标识锁的拥有者
         * 3. NX：不存在即set，存在则不处理
         * 4. PX: 锁的超时时间
         */
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        //使用eval， 将命令交给redis服务器处理，eval可以保证原子性
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
    }
}
