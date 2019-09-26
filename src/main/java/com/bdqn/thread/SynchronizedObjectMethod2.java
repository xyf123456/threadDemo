package com.bdqn.thread;

/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 对象锁的同步方法形式
 * create time: 2019/9/5 21:49
 */
public class SynchronizedObjectMethod2 implements Runnable {
    private static SynchronizedObjectMethod2 instance = new SynchronizedObjectMethod2();

    @Override
    public void run() {
        method();
    }

    /**
     * description: TODO 同步了普通方法
     * create time: 2019/9/5 22:18
     * []
     *
     * @return void
     */
    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedObjectMethod2.instance);
        Thread thread2 = new Thread(SynchronizedObjectMethod2.instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
