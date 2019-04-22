package com.john.designpattern.singleton;

/**
 * 饿汉法： 进程启动时，立即进行类加载并初始化
 * 缺点： 无法做到延迟加载
 */
public class SingletonHungry {

    private static SingletonHungry instance = new SingletonHungry();

    private  SingletonHungry(){}

    public SingletonHungry getInstance(){
        return instance;
    }
}
