package com.bdqn.utils;

import com.bdqn.pojo.Student;
import com.bdqn.pojo.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonUtilTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Description: TODO 测试JSON数据和String类型的数据之间的转化
     * param: []
     * return: void
     * Date: 2019/10/8 11:33
     */
    @Test
    public void listToJson() throws Exception {

        /*Student student1 = new Student(1,"张三");
        Student student2 = new Student(1,"李四");
        Teacher teacher1 = new Teacher("张老师",23);
        Teacher teacher2 = new Teacher("李老师",26);
        List<Student> list = new ArrayList<>();
        List<Teacher> list1= new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list1.add(teacher1);
        list1.add(teacher2);
        String listToJson1=JsonUtil.listToJson(list);
        String listToJson2=JsonUtil.listToJson(list1);
        System.out.println(listToJson1);
        System.out.println(listToJson2);
        System.out.println(list);
        System.out.println(list1);*/
        String jsonString = "[{\"age\":0,\"id\":1,\"name\":\"张三\"},{\"age\":0,\"id\":1,\"name\":\"李四\"}]";
        List<Teacher> list=JsonUtil.jsonToList(jsonString,Teacher.class);
        for (Teacher s:
             list) {
            System.out.println(s);
        }
    }

    /**
     * Description: TODO 进制转换之间的测试
     * param: []
     * return: void
     * Date: 2019/10/8 11:41
     */
    @Test
    public void test(){
        int i1 = 1;
        int i2 = 100;
//        Integer.toHexString(i1);
//        Integer.toHexString(i2);
        System.out.println("二进制:"+Integer.toBinaryString(i1));
        System.out.println("二进制:"+Integer.toBinaryString(i2));
        System.out.println("八进制:"+Integer.toOctalString(i2));
        System.out.println("十六进制:"+Integer.toHexString(i2));
        System.out.println("三进制:"+Integer.toString(i2,3));
        System.out.println(10<<4);
        System.out.println(1>>2);
    }

}