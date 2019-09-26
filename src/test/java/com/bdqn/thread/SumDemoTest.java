package com.bdqn.thread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumDemoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSum() throws Exception{
        //单元测试默认不支持多线程
        Thread thread1 = new Thread(SumDemo.instance);
        Thread thread2 = new Thread(SumDemo.instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(SumDemo.i);
    }
}