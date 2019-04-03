package com.john.javacore;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread() + "正在运行。。。");
                    Thread.sleep(2000);
                    System.out.println("子线程" + Thread.currentThread() + "运行完毕。。。");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            System.out.println("等待子线程执行完毕。。。");
            latch.await();
            System.out.println(">>>>>>>>>>子线程已全部执行完毕");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
