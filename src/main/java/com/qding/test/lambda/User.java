package com.qding.test.lambda;

public class User {
//    1, "u1", "shenyang", "hahaha"？

    public User() {
    }

    public User(int num, String userId, String name, String desc) {
        this.num = num;
        this.userId = userId;
        this.name = name;
        this.desc = desc;
    }

    private int num;
    private String userId;
    private String name;
    private String desc;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
