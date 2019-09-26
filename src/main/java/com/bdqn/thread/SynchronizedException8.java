package com.bdqn.thread;

/**
 * ClassName: SynchronizedObjectCodeBlock1
 * create by:  xyf
 * description: TODO 方法抛出异常后，会释放锁
 * create time: 2019/9/5 21:49
 */
public class SynchronizedException8 implements Runnable {
    private static SynchronizedException8 instance = new SynchronizedException8();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    /**
     * description: TODO 同步了的静态方法
     * create time: 2019/9/5 22:18
     * []
     *
     * @return void
     */
    public synchronized  void method1() {
        System.out.println("我是加对象锁的同步方法形式，我叫" + Thread.currentThread().getName());
        /*try {
            Thread.sleep(2000);
            //在这里主动抛出异常,但是这里有问题，就是catch中捕获了异常，后续代码还会进行，不能充分说明
            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在try catch后面主动抛出异常，才能充分说明，异常抛出后，有无释放锁对象
        throw new RuntimeException();
//        System.out.println(Thread.currentThread().getName() + "执行完成！");
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
        Thread thread1 = new Thread(SynchronizedException8.instance);
        Thread thread2 = new Thread(SynchronizedException8.instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {//直到两个线程执行完成

        }
        System.out.println("finished");
    }
}
