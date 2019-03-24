package com.leetcode.singleton;

/**
 * 懒汉法，不是线程安全的， 有多个线程getInstance的时候， 可能会创建多个对象
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy (){}

    public static SingletonLazy getInstance(){
        if(instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
