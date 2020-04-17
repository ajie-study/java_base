package com.study.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试Thread类的sleep()
 *
 * @author ajie
 * @date 2019-10-11 10:24
 */

public class Sleep {

    /**
     * sleep方法告诉操作系统至少指定时间内不需为线程调度器为该线程分配执行时间片，
     * 并不释放锁（如果当前已经持有锁）。实际上，调用sleep方法时并不要求持有任何锁。
     */
    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Thread thread1 = new Thread(() -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(format.format(new Date()) + " Thread1 is running");
                    //必须指定休眠时间
                    Thread.sleep(2000);
                    System.out.println(format.format(new Date()) + " Thread1 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(format.format(new Date()) + " Thread2 is running");
                    //不一定要放在同步代码块中
                    Thread.sleep(2000);
                    System.out.println(format.format(new Date()) + " Thread2 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for (long i = 0; i < 200000; i++) {
                for (long j = 0; j < 100000; j++) {
                }
            }
        });

        // Don't use sleep method to avoid confusing
        for (long i = 0; i < 200000; i++) {
            for (long j = 0; j < 100000; j++) {
            }
        }
        thread2.start();
    }

}
