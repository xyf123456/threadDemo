package com.bdqn.thread;

/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 类锁的静态方法形式
 * create time: 2019/9/5 21:49
 */
public class SynchronizedClassStatic3 implements Runnable {
    private static SynchronizedClassStatic3 instance1 = new SynchronizedClassStatic3();
    private static SynchronizedClassStatic3 instance2 = new SynchronizedClassStatic3();

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
    public synchronized static void method() {
        System.out.println("我是类锁的第一种形式静态方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成！");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(SynchronizedClassStatic3.instance1);
        Thread thread2 = new Thread(SynchronizedClassStatic3.instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
