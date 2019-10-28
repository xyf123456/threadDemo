package com.bdqn.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * ClassName: {@link User}
 * create by:  xyf
 * description:  用户类
 * create time: 2019/10/28 10:40
 */
@Data
@ToString
public class User {

    private String name;
    private int age;
    private CharacterType character;


    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age,CharacterType character) {
        this(name,age);
        this.character = character;
    }
}
