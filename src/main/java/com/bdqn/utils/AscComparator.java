package com.bdqn.utils;

import com.bdqn.pojo.Teacher;

import java.util.Comparator;

/**
 * ClassName: AscComparator
 * create by:  xyf
 * description: TODO 定制排序的规则
 * 1、Comparable 更像是自然排序，实现了Comparable接口，重写compareTo(Object o)方法进行比较；
 2、自定义编写实现了Comparator接口的类，重写compare(Object o1,Object o2)方法进行比较，更像是定制排序；
 3、引入第三方jar包，构造BeanComparator比较器，更便捷
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
