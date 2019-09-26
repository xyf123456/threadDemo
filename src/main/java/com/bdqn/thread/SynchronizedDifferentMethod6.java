package com.bdqn.thread;

/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 同时访问同一个类的不同的普通同步方法
 * create time: 2019/9/5 21:49
 */
public class SynchronizedDifferentMethod6 implements Runnable {
    private static SynchronizedDifferentMethod6 instance = new SynchronizedDifferentMethod6();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    /**
     * description: TODO 同步了普通方法
     * create time: 2019/9/5 22:18
     * []
     *
     * @return void
     */
    public synchronized void method1() {
        System.out.println("我是加锁形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    /**
     * 非同步方法
     */
    public synchronized void method2() {
        System.out.println("我是加锁形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedDifferentMethod6.instance);
        Thread thread2 = new Thread(SynchronizedDifferentMethod6.instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
