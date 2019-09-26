package com.bdqn.thread;
/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 同步代码块（同一个对象的锁和不同的对象锁）
 * create time: 2019/9/5 21:49
 */
public class SynchronizedObjectCodeBlock1 implements Runnable{
//    static SynchronizedObjectCodeBlock1 instance = new SynchronizedObjectCodeBlock1();
    static SynchronizedObjectCodeBlock1 instance1 = new SynchronizedObjectCodeBlock1();
    static SynchronizedObjectCodeBlock1 instance2 = new SynchronizedObjectCodeBlock1();
    Object lock1 = new Object();
    Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("我是对象锁的代码块形式，我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完成！");
        }
        /*synchronized (lock1) {
            System.out.println("我是lock1对象锁，我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1对象锁部分 执行完成！");
        }
        synchronized (lock2) {
            System.out.println("我是lock2对象锁，我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2对象锁部分 执行完成！");
        }*/

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedObjectCodeBlock1.instance1);
        Thread thread2 = new Thread(SynchronizedObjectCodeBlock1.instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive()||thread2.isAlive()){//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
