package com.qding.test.lambda;

public class Student {
    private String id;
    private String name;
    private Double score;

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public Student(String id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\":\"" + name + "\""
                + ", \"score\":\"" + score + "\""
                + "}";
    }

}
