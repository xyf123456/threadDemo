package com.bdqn.pojo;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TestTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * description: 将List集合转换成Map
     * create time: 2019/11/6 14:28
     * $params []
     * $return void
     */
    @Test
    public void test() {
        List<TestDemo> list = new ArrayList<TestDemo>();
        list.add(new TestDemo(1, "测试1"));
        list.add(new TestDemo(2, "测试2"));

        //        第一种方式传统的方式
       /* Map<Integer,TestDemo> map = new HashMap<>();
        for (TestDemo te:
             list) {
            map.put(te.getUnique(),te);
        }
        System.out.println(map);
        assertTrue(map.size()==2);*/
        //       第二种方式，使用 JAVA 8直接用流的方法：
        /*Map<Integer,TestDemo> map =list.stream().collect(Collectors.toMap(TestDemo::getUnique,p->p));
        System.out.println(map);
        assertTrue(map.size()==2);*/
        //       第三种方式使用guava 工具类库
        Map<Integer,TestDemo> map = Maps.uniqueIndex(list, new Function<TestDemo, Integer>() {
            @Override
            public Integer apply(TestDemo testDemo) {
                return testDemo.getUnique();
            }
        });
        System.out.println(map);
        assertTrue(map.size()==2);
    }
}