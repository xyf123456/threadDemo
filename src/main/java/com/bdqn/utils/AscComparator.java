package com.bdqn.utils;

import com.bdqn.pojo.Teacher;

import java.util.Comparator;

/**
 * ClassName: AscComparator
 * create by:  xyf
 * description: TODO 定制排序的规则
 * 1、Comparable 更像是自然排序

 2、Comparator 更像是定制排序
 * create time: 2019/9/14 0014 上午 11:41
 */
public class AscComparator implements Comparator<Teacher>{
    /*@Override
    public int compare(Teacher o1, Teacher o2) {
//        根据年龄降序排列
        return o1.getAge()-o2.getAge();
    }*/

    @Override
    public int compare(Teacher o1, Teacher o2) {
//        根据年龄升序排列
        return o2.getAge()-o1.getAge();
    }
}
