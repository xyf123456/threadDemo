package com.bdqn.thread;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * ClassName: {@link SumDemo}
 * create by:  xyf
 * description: TODO  求和(多线程的案例)
 * synchronized的两种用法:
 * 对象锁：方法锁和同步代码块
 * 类锁：指synchronized修饰静态方法或指定锁为Class对象
 * 类锁：JAVA可能有多个对象，但是只有1个Class对象，类锁的本质是Class对象锁；
 * synchronized加在static方法上；类锁只能在同一时刻被一个对象拥有；
 * synchronized(*.class)代码块上,类锁只能在同一时刻被一个对象拥有；
 *
 * 多线程访问同步方法的七种情况：
 * 1、两个线程同时访问一个对象的同步方法；（会受到干扰，因为是同一个对象的锁）
 * 2、两个线程访问的是两个对象的同步方法；（不会受干扰，因为锁对象不是同一个）
 * 3、两个线程访问的是synchronized的静态方法（虽然是不同的实例对象，但是同一个类，是持有的类锁，会受到干扰）
 *
 * 4、同时访问同步方法和非同步方法(非同步方法不受影响，因为synchronized只作用于当前方法)
 * 5、访问同一个对象的不同的普通同步方法（synchronized默认的是this对象的锁，尽管是不同的方法，会受到干扰，串行 执行，而非并行）
 * 6、同时访问静态synchronized和非静态的synchronized方法（不会受干扰，因为锁对象不是同一个，一个是类对象锁，一个类的对象的锁）
 * 7、方法抛出异常后，会释放锁？ 会的 ，JVM帮助我们释放了锁对象，其他同步方法依然可以持有锁，需要和Lock接口对比，Lock不会释放锁；
 *
 * 总结：（1）一把锁同时只能被 一个线程获取，没有拿到锁的线程必须等待（对应情况为1和5）；
 *       （2）每个实例都可以作为一把锁，不同实例之间互不影响，例外：锁对象是*.class以及synchronized修饰的
 *       是static方法的时候，所有对象共用一把锁（对应情况2,3,4 ,6）
 *       （3）无论是方法正常执行完成还是抛出异常，都会释放锁对象（对应情况7）
 *       （4）目前我进入到被synchronized修饰的方法，而这个方法中调用了一个没有被synchronized修饰的方法，
 *          线程是否安全，不安全，由于另一个方法没有被synchronized修饰，线程是不安全的，可以被同时访问的。
 *
 * synchronized性质:可重入(区别于其他锁的重要性质)；不可中断（劣势）；
 * 可重入：指的是同一线程的外层函数获得锁之后，内层函数可以直接再次获取该锁；也指只要我拿到
 * 一把锁，那我就无须释放锁，不需要和别人竞争抢锁，就能继续使用这把锁；也叫递归锁；
 * 在JAVA环境下 ReentrantLock 和synchronized 都是 可重入锁。
 * 不可重入的例子：汽车上牌照，摇号上牌，一次只能上一个车；
 * 可重入的好处：（1）避免死锁（假设synchronized不具备可重入性，两个同步方法执行，线程A执行方法1，获得锁，
 * 方法2也是同步，想要执行方法2需要拿到锁对象，既想拿锁，又不释放锁对象，造成死锁，永远等待）；
 * （2）提升封装性（避免了一次次的解锁和加锁，提高封装，简化了并发的难度）；
 *
 *
 * 粒度：线程而非调用（用3中情况来说明和pthread的区别，Linux中的pthread）；
 * 3个证明:
 * 情况1：证明同一个方法是可重入的；
 * 情况2：证明可重入不要求是同一个方法；
 * 情况3：证明可重入不要求是同一个类中的；
 * create time: 2019/9/5 21:24
 */
public class SumDemo implements Runnable {

    static SumDemo instance = new SumDemo();
    static int i = 0;

    @Override
    public void run() {
        //第一种方法：直接将synchronized加到方法上
//    public synchronized void run() {

//        第二种方法：同步代码块
        /*synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }*/
//        第三种方法：使用类锁
        synchronized (SumDemo.class) {
            for (int j = 0; j < 100000; j++) {
                i++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(SumDemo.instance);
        Thread thread2 = new Thread(SumDemo.instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(SumDemo.i);
    }
}
