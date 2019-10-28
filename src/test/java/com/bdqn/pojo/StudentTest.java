package com.bdqn.pojo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StudentTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test() throws Exception {
        //        Student student1 = new Student();
        Student student1 = new Student(1, "张三", 23);
        Student student2 = new Student(2, "张三", 23);
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        System.out.println(student1.equals(student2));
        System.out.println(student1.hashCode()==student2.hashCode());
        System.out.println(studentSet);
        System.out.println(2<<5);
}

    @Test
    public void test1() throws Exception {
        //        Student student1 = new Student();
        Student student1 = new Student(1, "张三", 23);
        Student student2 = new Student(2, "张三", 23);
        Student student3 = new Student(3, "张三", 23);
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        System.out.println(student1.equals(student2));
        System.out.println(student1.hashCode() == student2.hashCode());
        System.out.println(studentSet);
//        显然，这不是我们要的结果，我们是希望两个对象如果相等，那么在使用 hashSet 存储时也能认为这两个对象相等。
//        通过看 hashSet 的 add 方法能够得知 add 方法里面使用了对象的 hashCode 方法来判断，所以我们需要重写 hashCode
//        方法来达到我们想要的效果。
       /* hashCode 是用于散列数据的快速存取，如利用 HashSet/HashMap/Hashtable 类来存储数据时，都会根据存储对象的
        hashCode 值来进行判断是否相同的。*/
    }

    @Test
    public void testList() throws Exception {
        //        Student student1 = new Student();
        Student student1 = new Student(1, "张三", 23);
        Student student2 = new Student(2, "李四", 33);
        Student student3 = new Student(3, "王五", 15);
        /*List<Student> studentList = new LinkedList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student stu:
             studentList) {
            System.out.println(stu);
        }*/
       /* List<Student> studentList = new Vector<>();//线程安全
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student stu:
             studentList) {
            System.out.println(stu);
        }*/
        List<Student> studentList = new ArrayList<>();//线程非安全
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student stu :
                studentList) {
            System.out.println(stu);
        }
//        拉姆达表达式
        studentList.stream().forEach(student -> {
            System.out.println(student);
        });
    }

    /**
     * description: TODO  java 8的新特性之一就是lambda表达式，都说性能会比较高，现一探究竟。
     * create time: 2019/9/13 0013下午 9:30
     *
     * @ param []
     * @ return void
     */
    @Test
    public void testLambda() throws Exception {
       /* 对于耗时的操作用lambda表达式的for循环，如数据库的IO操作，多线程充分利用CPU资源；
        对于不太耗时的操作使用普通for循环，比如纯CPU计算类型的操作，单线程性能更高，减少上
        下文切换的开销。*/
//        List<String> list = new ArrayList<>();
        List<String> list = new Vector<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }

        long startTime = System.currentTimeMillis();
        /*for (Object o :
                list) {
            Thread.sleep(1);
                  //普通for循环只有主线程在处理。
            System.out.println(o.toString());
        }*/
       /* list.stream().forEach(s -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s.toString());
        });*/
        list.parallelStream().forEach(s -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s.toString());
        });
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "ms");
    }

    @Test
    public void testSet() throws Exception {
        Student student1 = new Student(1, "张三", 23);
        Student student2 = new Student(2, "李四", 33);
        Student student3 = new Student(3, "王五", 15);
        /*Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.forEach(student -> {
            System.out.println(student);
        });*/
       /* LinkedHashSet继承自HashSet，源码更少、更简单，唯一的区别是LinkedHashSet内部使用的是LinkHashMap。
        这样做的意义或者好处就是LinkedHashSet中的元素顺序是可以保证的，也就是说遍历序和插入序是一致的。*/
        /*LinkedHashSet 是 Set 的一个具体实现，其维护着一个运行于所有条目的双重链接列表。
        此链接列表定义了迭代顺序，该迭代顺序可为插入顺序或是访问顺序。
        如果需要迭代的顺序为插入顺序或者访问顺序，那么 LinkedHashSet 是需要你首先考虑的。*/
       /* Set<Student> studentSet = new LinkedHashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(null);
        studentSet.add(null);
        studentSet.forEach(student -> {
            System.out.println(student);
        });*/
//        TreeSet是一种排序二叉树。存入Set集合中的值，会按照值的大小进行相关的排序操作。底层算法是基于红黑树来实现的。
//        TreeSet和HashSet的主要区别在于TreeSet中的元素会按照相关的值进行排序~
        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.forEach(student -> {
            System.out.println(student);
        });

    }

    @Test
    public void testCollections() throws Exception {
        Student student1 = new Student(1, "张三", 23);
        Student student2 = new Student(2, "李四", 33);
        Student student3 = new Student(3, "王五", 15);
        Student student4 = new Student(4, "徐柳", 88);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student3);
        students.add(student2);
        students.add(student4);
        students.stream().forEach(student -> {
            System.out.println(student);
        });
//        Collections.sort(students);
        System.out.println("排序后:");
        students.stream().forEach(student -> {
            System.out.println(student);
        });
    }

}