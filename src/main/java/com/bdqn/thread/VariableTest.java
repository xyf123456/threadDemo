package com.bdqn.thread;

/**
 * ClassName: VariableTest
 * create by:  xyf
 * description: TODO volatile修饰符的应用
 * create time: 2019/11/4 22:36
 *
 * 以上运行结果证明：线程B修改变量flag之后，线程A读取不到，A线程一直在运行，无法停止。
 * 内存不可见的两个原因：
 * 1、cache机制导致内存不可见;
 * 我们都知道，CPU的运行速度是远远高于内存的读写速度的，为了不让cpu为了等待读写内存数据，
 * 现代cpu和内存之间都存在一个高速缓存cache（实际上是一个多级寄存器）;
 * 线程在运行的过程中会把主内存的数据拷贝一份到线程内部cache中，也就是working memory。
 * 这个时候多个线程访问同一个变量，其实就是访问自己的内部cache。
 * 上面例子出现问题的原因在于：线程A把变量flag加载到自己的内部缓存cache中，线程B修改变
 * 量flag后，即使重新写入主内存，但是线程A不会重新从主内存加载变量flag，看到的还是自己
 * cache中的变量flag。所以线程A是读取不到线程B更新后的值。
 * 2、除了cache的原因，重排序后的指令在多线程执行时也有可能导致内存不可见，由于指令顺序
 * 的调整，线程A读取某个变量的时候线程B可能还没有进行写入操作呢，虽然代码顺序上写操作是
 * 在前面的。
 *
 * volatile的原理：
 * volatile修饰的变量不允许线程内部cache缓存和重排序，线程读取数据的时候直接读写内存，
 * 同时volatile不会对变量加锁，因此性能会比synchronized好；
 * 另外还有一个说法是使用volatile的变量依然会被读到cache中，只不过当B线程修改了flag之
 * 后，会将flag写回主内存，同时会通过信号机制通知到A线程去同步内存中flag的值。
 */
public class VariableTest {

    private volatile static boolean flag = false;
//    private  static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        new Thread(threadA, "threadA").start();
        Thread.sleep(1000l);//为了保证threadA比threadB先启动，sleep一下
        new Thread(threadB, "threadB").start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + ":flag is " + flag);
                    break;
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            flag = true;
            System.out.println(Thread.currentThread().getName() + ":flag is " + flag);
        }
    }
}
