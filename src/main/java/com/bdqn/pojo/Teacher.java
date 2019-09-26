package com.bdqn.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Comparator;

/**
 * ClassName: Teacher
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/14 0014 上午 11:38
 */
@Data
@ToString
public class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Teacher o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
