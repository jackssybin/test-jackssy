package com.qding.test.calc.abstrafactory;

public class Client {
    public static void main(String[] args) {
        FactoryAB factory;
        factory = new FactoryA();
        factory.createProduct();
        factory = new FactoryB();
        factory.createProduct();
        factory = new FactoryC();
        factory.createProduct();
    }
}