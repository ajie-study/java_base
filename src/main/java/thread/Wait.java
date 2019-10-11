package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试java中的wait()方法
 *
 * @author ajie
 * @date 2019-10-10 19:32
 */


public class Wait {

    /**
     * wait是在当前线程持有wait对象锁的情况下，暂时放弃锁，并让出CPU资源，
     * 并积极等待其它线程调用同一对象的notify或者notifyAll方法。
     * 注意，即使只有一个线程在等待，并且有其它线程调用了notify或者notifyAll方法，等待的线程只是被激活，
     * 但是它必须得再次获得锁才能继续往下执行。
     * 换言之，即使notify被调用，但只要锁没有被释放，原等待线程因为未获得锁仍然无法继续执行。测试代码如下所示
     */

    public static void main(String[] args) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //线程一
        Thread thread1 = new Thread(() -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(format.format(new Date()) + " Thread1 is running");
                    //wait方法调用必须放在synchronized中
                    Wait.class.wait();
                    System.out.println(format.format(new Date()) + " Thread1 ended");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        thread1.start();

        //线程二
        Thread thread2 = new Thread(() -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(format.format(new Date()) + " Thread2 is running");
                    //唤醒等待的线程
                    Wait.class.notify();

                    for (long i = 0; i < 200000; i++) {
                        for (long j = 0; j < 100000; j++) {
                        }
                    }
                    System.out.println(format.format(new Date()) + " Thread2 release lock");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            for (long i = 0; i < 200000; i++) {
                for (long j = 0; j < 100000; j++) {
                }
            }
            System.out.println(format.format(new Date()) + " Thread2 ended");
        });

        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }

        thread2.start();

    }
}
