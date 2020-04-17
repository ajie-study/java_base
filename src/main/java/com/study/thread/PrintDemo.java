package com.study.thread;

/**
 * 面试题：
 * 两个线程如何交替执行、一个输出偶数一个输出奇数
 */
public class PrintDemo {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        //创建两个线程
        Thread thread1 = new Thread(printDemo :: printOUSHU);
        Thread thread2 = new Thread(printDemo :: printJISHU);

        //开启线程
        thread1.start();
        thread2.start();
    }

    //打印偶数
    public synchronized void printOUSHU(){

        for (int i = 0; i <= 100; i+=2) {

            System.out.println(Thread.currentThread().getName() + "----" + i);
            //1、唤醒
            this.notify();

            try{
                //2、线程进入等待 --  失去锁
                this.wait();
                //3、线程沉睡 -- 拥有锁
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println("打印偶数异常");
            }
        }
    }

    //打印奇数
    public synchronized void printJISHU(){

        for (int i = 1; i <= 100; i+=2) {

            System.out.println(Thread.currentThread().getName() + "----" + i);
            //1、唤醒
            this.notify();

            try{
                //2、线程进入等待 --  失去锁
                this.wait();
                //3、线程沉睡 -- 拥有锁
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println("打印奇数异常");
            }
        }
    }
}
