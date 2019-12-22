package com.bdqn.thread;

/**
 * ClassName: SynchronizedRecursionSuperClass12
 * create by:  xyf
 * description: 可重入性质代码演示:通过调用其他类中的同步方法
 * create time: 2019/12/22 9:00
 */
public class SynchronizedRecursionSuperClass12 {

    public synchronized void doSomething(){
        System.out.println("我是父类方法");
    }
}

class SynchronizedRecursionSubClass12 extends SynchronizedRecursionSuperClass12{
    @Override
    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        SynchronizedRecursionSubClass12 synchronizedRecursionSubClass12 = new SynchronizedRecursionSubClass12();
        synchronizedRecursionSubClass12.doSomething();
    }
}
