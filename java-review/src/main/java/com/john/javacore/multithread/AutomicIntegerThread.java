package com.john.javacore.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicIntegerThread {

    public static AtomicInteger atint = new AtomicInteger(0);
    public static void main(String[] args) {
        for(int i=0; i<10;){
            new Thread(()->{
                atint.incrementAndGet();
            }).start();
        }
    }
}
