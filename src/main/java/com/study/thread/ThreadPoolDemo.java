package com.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version ：V1.0
 * @program: my-project
 * @description: 基于线程池方式创建线程
 * @author: zhj
 * @create: 2020-04-20 10:39
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        while(true) {
            threadPool.execute(new Runnable() { // 提交多个线程任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running ..");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}