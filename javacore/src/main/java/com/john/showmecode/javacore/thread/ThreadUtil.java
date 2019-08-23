package com.john.showmecode.javacore.thread;

import java.util.concurrent.*;

/**
 * @Author: kangq
 * @Date: 2019/8/23 10:04
 */
public class ThreadUtil {

    /**
     * 新建一个线程池
     *
     * @param threadSize 同时执行的线程数大小
     * @return ExecutorService
     */
    public static ExecutorService newExecutor(int threadSize){
        final BlockingQueue<Runnable> workQueue;
        workQueue = (threadSize <= 0) ? new SynchronousQueue<Runnable>() : new LinkedBlockingQueue<Runnable>();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();


        final ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                threadSize,
                Integer.MAX_VALUE,
                TimeUnit.SECONDS.toNanos(60), TimeUnit.NANOSECONDS,
                workQueue,
                threadFactory,
                handler
        );
        return threadPoolExecutor;

    }
}
