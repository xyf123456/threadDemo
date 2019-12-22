package com.bdqn.thread;

/**
 * ClassName: SynchronizedRecursion10
 * create by:  xyf
 * description: 可重入性质代码演示:通过递归调用本方法
 * create time: 2019/12/22 8:46
 */
public class SynchronizedRecursion10 {
    int a = 0;

    public synchronized void method1() {
        System.out.println("这是method1 ，a = " + a);
        if (a == 0) {
            a++;
            method1();
        }
    }

    public static void main(String[] args) {
        SynchronizedRecursion10 synchronizedRecursion10 = new SynchronizedRecursion10();
        synchronizedRecursion10.method1();
    }
}
