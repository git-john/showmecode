package com.john.spring.aop;

public class Logger {

    public void recordBefore(){
        System.out.println("record before,now is:" + System.currentTimeMillis());
    }

    public void recordAfter(){
        System.out.println("record after, nowtime is:" + System.currentTimeMillis());
    }
}
