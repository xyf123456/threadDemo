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
 *
 * 两个对象equals，则hashCode一定相等，因为计算方式一样;
 * 两个对象不equals，则hashCode不一定不相等,因为可能存在地址冲突
 * 两个对象hashCode相等，对象不一定equals,因为可能存在地址冲突
 * 两个对象hashCode不相等，对象一定不equals;
 *
 * 　所以：hashCode 是用于散列数据的快速存取，如利用 HashSet/HashMap/Hashtable 类
 * 来存储数据时，都会根据存储对象的 hashCode 值来进行判断是否相同的。
 */
//@Data
//@ToString
public class Student implements Comparable<Student> {
//public class Student{

    private Integer id;
    private String name;
    private int age;
    private int weight;

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

    public Student(Integer id, String name, int age, int weight) {
        this(id, name, age);
        this.weight = weight;
    }

    /**
     * description:  重写equals方法
     * 因为不重写 equals 方法，执行 student1.equals(student2) 比较的就是两个对象的地址
     * （即 student1 == student2），肯定是不相等的
     * create time: 2019/10/19 13:42
     * $params [o]
     * $return boolean
     */
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
        if (StringUtil.equalsStr(this.name, student.name)
                && this.age == student.age) {
            return true;
        }
        return false;
    }

    /**
     * description:　其实当 equals 方法被重写时，通常有必要重写 hashCode 方法，
     * 以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
     * 生成一个 int 类型的变量 result，并且初始化一个值，比如17
     * 　对类中每一个重要字段，也就是影响对象的值的字段，也就是 equals 方法里有比较的字
     * 段，进行以下操作：a. 计算这个字段的值 filedHashValue = filed.hashCode(); b. 执行
     * result = 31 * result + filedHashValue;
     * 重写hashCode()为啥要用31来:
     * 原因一：更少的乘积结果冲突;31是质子数中一个“不大不小”的存在;进行 hash code
     * 运算，并使用常数 31, 33, 37, 39 和 41 作为乘子；
     * 原因二：31 可以被 JVM 优化，　JVM里最有效的计算方式就是进行位运算了；
     *  左移 << : 左边的最高位丢弃，右边补全0（把 << 左边的数据*2的移动次幂）;
     *  右移 >> : 把>>左边的数据/2的移动次幂。
     *无符号右移 >>> : 无论最高位是0还是1，左边补齐0。 　　
     * 31 * i = (i << 5) - i（左边  31*2=62,右边   2*2^5-2=62）,JVM就可以高效的进行计算啦
     * hashCode 是用于散列数据的快速存取，如利用 HashSet/HashMap/Hashtable 类来存储数据时，
     * 都会根据存储对象的 hashCode 值来进行判断是否相同的。
     *
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
