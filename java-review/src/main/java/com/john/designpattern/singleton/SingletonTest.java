package com.john.designpattern.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        EnumSingle.INSTANCE.printHello();
        new Thread(()->{
            System.out.println("hello thread~");
        }).start();
    }
}
