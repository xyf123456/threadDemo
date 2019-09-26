package com.bdqn.pojo;

import com.bdqn.utils.StringUtil;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Student
 * create by:  xyf
 * description: TODO 测试集合框架的实体类
 * create time: 2019/9/13 0013 下午 8:11
 */
@Data
//@ToString
public class Student implements Comparable<Student> {
//public class Student{

    private Integer id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, int age) {
        this(id, name);
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {//非空性，：对于任意非空引用x，x.equals(null)应该返回false。
            return false;
        }
        if (this == o) {//如果两个对象的地址一样
            return true;
        }
        if (!(o instanceof Student)) {//类别判断，是否属于同一类
            return false;
        }
        //同一类前提下的属性
        Student student = (Student) o;
        if (StringUtil.equalsStr(this.name, ((Student) o).name)
                && this.age == ((Student) o).age) {
            return true;
        }
        return false;
    }

    /**
     * description: TODO  生成一个 int 类型的变量 result，并且初始化一个值，比如17
     * 　对类中每一个重要字段，也就是影响对象的值的字段，也就是 equals 方法里有比较的字
     * 段，进行以下操作：a. 计算这个字段的值 filedHashValue = filed.hashCode(); b. 执行
     * result = 31 * result + filedHashValue;
     * create time: 2019/9/13 0013下午 9:15
     *
     * @ param []
     * @ return int
     */
    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (age == 0 ? 0 : name.hashCode());
        return result;
    }


    @Override
    public int compareTo(Student student) {
        if (this.age > student.age) {
            return 1;
        } else if (this.age < student.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
