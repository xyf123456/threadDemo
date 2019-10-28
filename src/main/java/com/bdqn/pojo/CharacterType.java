package com.bdqn.pojo;

public enum CharacterType {
    IN("内向"),
    OUT("外向"),
    BOTH("太监"),
    UNKNOWN("不知道");

    private String name;


    CharacterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
