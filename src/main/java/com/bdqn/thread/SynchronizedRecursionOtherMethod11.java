package com.bdqn.thread;

/**
 * ClassName: SynchronizedRecursion10
 * create by:  xyf
 * description: 可重入性质代码演示:通过调用类中的其他方法
 * create time: 2019/12/22 8:46
 */
public class SynchronizedRecursionOtherMethod11 {

    public synchronized void method1() {
        System.out.println("这是method1 " );
        method2();
    }
    public synchronized void method2() {
        System.out.println("这是method2");
    }

    public static void main(String[] args) {
        SynchronizedRecursionOtherMethod11 synchronizedRecursionOtherMethod11 = new SynchronizedRecursionOtherMethod11();
        synchronizedRecursionOtherMethod11.method1();
    }
}
