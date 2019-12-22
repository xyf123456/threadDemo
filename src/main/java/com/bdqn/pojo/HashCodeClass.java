package com.bdqn.pojo;

import java.util.Objects;

/**
 * ClassName: HashCodeClass
 * create by:  xyf
 * description: TODO hashcode方法的重写
 * create time: 2019/11/4 23:35
 */
public class HashCodeClass {
    private String name;
    private int age;
    private double weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeClass)) return false;
        HashCodeClass that = (HashCodeClass) o;
        return age == that.age &&
                Double.compare(that.weight, weight) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight);
    }

    public static void main(String[] args) {
        System.out.println(new HashCodeClass().hashCode());
        System.out.println(new HashCodeClass().hashCode());
        System.out.println(new HashCodeClass().hashCode());
        System.out.println(new HashCodeClass().hashCode());
        System.out.println(new HashCodeClass().hashCode());
        System.out.println(new HashCodeClass().hashCode());
    }
}
