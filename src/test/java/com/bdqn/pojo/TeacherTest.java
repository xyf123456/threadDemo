package com.bdqn.pojo;

import com.bdqn.utils.AscComparator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.CollationElementIterator;
import java.util.*;

import static org.junit.Assert.*;

public class TeacherTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComparator() throws Exception {
//        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher1 = new Teacher("张三", 23);
        Teacher teacher2 = new Teacher("李四", 54);
        Teacher teacher3 = new Teacher("王五", 12);
        Teacher teacher4 = new Teacher("许六", 33);
        List<Teacher> teacherList = Arrays.asList(teacher1, teacher2, teacher3, teacher4);
       /* List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher1);
        teacherList.add(teacher2);
        teacherList.add(teacher3);
        teacherList.add(teacher4);*/
        Collections.sort(teacherList);
        teacherList.parallelStream().forEach(teacher -> {
            System.out.println(teacher);
        });
        // 1. 可以实现自己的外部接口进行排序
       /* System.out.println("排序后:");
        teacherList.sort(new AscComparator());
        System.out.println(teacherList);*/
//        单独测试AscComparator
       /* System.out.println("排序后:");
        AscComparator ascComparator = new AscComparator();
        int result=ascComparator.compare(teacher1,teacher2);
        System.out.println(result);*/

        /*对于一些普通的数据类型（比如 String, Integer, Double…），
        它们默认实现了Comparable 接口，实现了 compareTo 方法，我们可以直接使用。*/
       /* 而对于一些自定义类，它们可能在不同情况下需要实现不同的比较策略，我们可以新
        创建 Comparator 接口，然后使用特定的 Comparator 实现进行比较。*/
    }

    @Test
    public void testCollections() throws Exception {
        List<String> stringList = new ArrayList<>();
       /* stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");*/
        stringList.add("a");
        stringList.add("wqq");
        stringList.add("c");
        stringList.add("d");
        stringList.add("q");
        System.out.println(stringList);
        /*********************对已知集合进行自然排序************************************/
        /*//对已知集合进行自然排序
        Collections.sort(stringList);
        stringList.stream().forEach(s -> {
            System.out.print(s);
        });*/
        /*********************对已知集合进行随机排序************************************/
        /*   //对已知集合进行随机排序
        Collections.shuffle(stringList);
        stringList.stream().forEach(s -> {
            System.out.print(s);
        });
        System.out.println();
        Collections.shuffle(stringList);
        stringList.stream().forEach(s -> {
            System.out.print(s);
        });*/
        /*********************在已知集合（已经排序了的集合）查找元素************************************/
      /* int index =  Collections.binarySearch(stringList,"b");
        System.out.println("w所在的位置:"+index);*/
        /*********************在已知集合查找最大和最小元素************************************/
       /* String max=Collections.max(stringList);
        System.out.println("最大元素:"+max);
        String min=Collections.min(stringList);
        System.out.println("最小元素:"+min);*/
        /*********************在已知集合查找元素(也可以是集合)首次出现的位置************************************/
       /* List list = Arrays.asList("a b c d e d e".split(" "));
        System.out.println(list);
        List subList1 = Arrays.asList("c d e".split(" "));
        List subList2 = Arrays.asList("d e".split(" "));
        int index1 =Collections.indexOfSubList(list,subList1);
        int index2 =Collections.lastIndexOfSubList(list,subList2);
        System.out.println("subList1集合在list集合中首次出现位置:"+index1);
        System.out.println("subList2集合在list集合中最后出现位置:"+index2);*/
        /*********************在已知集合中进行元素替换************************************/
       /* List list = Arrays.asList("a b c d e d e".split(" "));
        System.out.println(list);
        System.out.println(Collections.replaceAll(list,"c","bbb"));
        System.out.println("替换后的集合:"+list);*/
        /*********************在已知集合中进行反转***********************************/
        /*List list = Arrays.asList("a b c d e".split(" "));
        System.out.println(list);
        Collections.reverse(list);
        System.out.println("反转后的集合:"+list);*/
        /*********************在已知集合中进行反转***********************************/
      /*  List list = Arrays.asList("a b c d e".split(" "));
        System.out.println(list);
        List newList = Arrays.asList("我 真 的 爱 你".split(" "));
        System.out.println(newList);
        Collections.copy(list,newList);
        System.out.println(list);*/
        /*********************在已知集合中元素交换***********************************/
      /*  List list = Arrays.asList("a b c d e".split(" "));
        System.out.println(list);
        Collections.swap(list,2,4);
        System.out.println(list);*/
        /*********************在已知集合中元素交换***********************************/
        /*List list = Arrays.asList("a b c d e".split(" "));
        System.out.println(list);
        Collections.fill(list,"f");
        System.out.println(list);*/
        /*********************返回大小为n的集合***********************************/
       /* System.out.println(Collections.nCopies(10,"w"));*/
    }
}