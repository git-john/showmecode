package com.leetcode.singleton;

/**
 * 使用volatile关键字禁止指令重排序优化，保证对其他线程可见， 对代码模块加锁， 可保证线程安全
 * 缺点：每次获取实例都需要排队，即便不需要new。 效率低下
 */
public class SingletonSync {

    private volatile static SingletonSync instance = null;

    private SingletonSync(){}

    public SingletonSync getInstance(){
        synchronized (SingletonSync.class){
            if(null == instance){
                instance = new SingletonSync();
            }
        }
        return instance;
    }
}
