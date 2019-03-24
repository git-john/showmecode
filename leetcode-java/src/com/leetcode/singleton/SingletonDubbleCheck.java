package com.leetcode.singleton;

public class SingletonDubbleCheck {

    private static volatile SingletonDubbleCheck instance;

    private SingletonDubbleCheck(){}

    public SingletonDubbleCheck getInstance(){
        if(null == instance){
            synchronized (SingletonDubbleCheck.class){
                if(null == instance){
                    instance = new SingletonDubbleCheck();
                }
            }
        }
        return instance;
    }
}
