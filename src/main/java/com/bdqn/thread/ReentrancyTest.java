package com.bdqn.thread;

/**
 * ClassName: {@link ReentrancyTest}
 * create by:  xyf
 * description:  synchronize的可重入的证明
 * create time: 2019/11/1 16:47
 *
 * ，首先明确一点，同步的方法一次只有一个线程能进入并执行，
 * 但是可重入和不可重入的概念是这样的：当一个线程获得了当
 * 前实例的锁，并进入方法A，则这个线程在没有释放这把锁的时
 * 候，能否再次进入方法A呢？
 * 可重入锁：可以再次进入方法A，就是说在释放锁前此线程可以
 * 再次进入方法A（方法A递归）。
 * 不可重入锁：不可以再次进入方法A，也就是说获得锁进入方法
 * A是此线程在释放锁前唯一的一次进入方法A。
 */
public class ReentrancyTest {
    private static int count = 0;

    private static synchronized void func(int seed) {
        func2(seed);
    }

    private static void func2(int seed) {
        if (seed <= 100) {
            count += seed;
            func(++seed);
        }
    }

    public static void main(String[] args) {
        func(1);
        System.out.println(count);
    }
}
