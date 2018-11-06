package com.qding.test.calc;

public class ParaVo {
    String name;
    double value;

    public ParaVo(String name, double value) {
        super();
        this.name = name;
        this.value = value;
    }
    public ParaVo() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
}