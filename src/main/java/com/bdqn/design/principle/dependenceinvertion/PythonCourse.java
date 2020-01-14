package com.bdqn.design.principle.dependenceinvertion;

/**
 * ClassName: JavaCourse
 * create by:  xyf
 * description: TODO
 * create time: 2020/1/14 12:01
 */
public class PythonCourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("学习Python");
    }
}
