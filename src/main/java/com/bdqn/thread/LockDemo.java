package com.bdqn.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: LockDemo
 * create by:  xyf
 * description: 和同步代码同等性质的代码演示（可中断性的测试，Lock）
 * create time: 2019/12/22 9:05
 */
public class LockDemo {
    Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是 synchronized 同步形式的method1");
//        method2();
    }

    public void method2(){
        lock.lock();//获得锁
        try {
            System.out.println("我是 lock 同步形式的method2");
        }finally {
                lock.unlock();//释放锁，放在finally代码块中，一定会执行释放锁的能力
        }
    }

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        lockDemo.method1();
        lockDemo.method2();
    }
}
