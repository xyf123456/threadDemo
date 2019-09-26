package com.bdqn.thread;

/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 同时访问静态synchronized和非静态的synchronized方法
 * create time: 2019/9/5 21:49
 */
public class SynchronizedStaticAndNoStatic7 implements Runnable {
    private static SynchronizedStaticAndNoStatic7 instance = new SynchronizedStaticAndNoStatic7();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    /**
     * description: TODO 同步了静态方法
     * create time: 2019/9/5 22:18
     * []
     *
     * @return void
     */
    public synchronized static void method1() {
        System.out.println("我是加类锁的第一种形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    /**
     *  TODO 同步了的静态方法
     */
    public synchronized void method2() {
        System.out.println("我是加对象锁的同步方法形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedStaticAndNoStatic7.instance);
        Thread thread2 = new Thread(SynchronizedStaticAndNoStatic7.instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
