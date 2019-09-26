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

}