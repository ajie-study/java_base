package com.study.CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @version ：V1.0
 * @program: my-project
 * @description: CAS全称 Compare And Swap（比较与交换），是一种无锁算法。
 * <p>
 * 在不使用锁（没有线程被阻塞）的情况下实现多线程之间的变量同步。java.util.concurrent包中的原子类就是通过CAS来实现了乐观锁。
 * CAS算法涉及到三个操作数：  需要读写的内存值 V。 进行比较的值 A。 要写入的新值 B。
 * 当且仅当 V 的值等于 A 时，CAS通过原子方式用新值B来更新V的值（“比较+更新”整体是一个原子操作），否则不会执行任何操作。
 * 一般情况下，“更新”是一个不断重试的操作。
 * @author: zhj
 * @create: 2020-04-22 15:15
 */
public class Example {

    //总访问量
    private static volatile int count = 0;

    //模拟用户的请求
    public static void request() throws InterruptedException {
        //模拟耗时五秒
        TimeUnit.MILLISECONDS.sleep(5);

        /**
         * count++ 是由三步组成（jvm执行引擎）
         *      I：获取count的值，记为A： A=count   ---->当同时有两个线程进入到第一步时，则会计算错误
         *      II:将A+1并赋值给B，B=A+1
         *      III：将B赋值为count
         *          改造：
         *              1.获取锁
         *              2.获取count的最新值记做：V
         *              3.判断A是否等于V，等于的话将B赋值给V，返回true，否则返回false
         *              4.释放锁
         */

        //计算总访问量
        // count++;

        //期望值
        int expectCount;
        while (!compareAndSwap(expectCount = getCount(), expectCount + 1)){

        }

    }


    /**
     * 第III改造代码 --->比较+更新
     * @param expectCount 期望值，是否跟当前的count相等
     * @param newCount 最新值，需要赋值给count的值
     * @return
     */
    public static synchronized boolean compareAndSwap(int expectCount, int newCount){

        if(getCount() == expectCount){
            count = newCount;
            return true;
        }

        return false;
    }

    /**
     * 获取当前的count
     * @return
     */
    private static int getCount() {
        return count;
    }


    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();  //开始时间

        //模拟100用户
        int userCount = 100;

        //栅栏 -- 等待计数器中的数值为0时，激活等待的进程
        CountDownLatch countDownLatch = new CountDownLatch(userCount);

        for (int i = 0; i < userCount; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        //每个用户访问10次
                        for (int j = 0; j < 10; j++) {

                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        countDownLatch.countDown(); //计数器减一
                    }

                }
            });

            //开启线程
            thread.start();
        }

        countDownLatch.await();   //等待计数器中的数值为0时，执行以下代码

        long endTime = System.currentTimeMillis();  //结束时间

        System.out.println(String.format("耗时：%d毫秒，总访问量为：%d", endTime - startTime, count));
    }
}