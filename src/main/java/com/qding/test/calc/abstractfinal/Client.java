package com.qding.test.calc.abstractfinal;

public class Client {
    public static void main(String[] args) {
        Factory factory;
        factory = new FactoryA();
        factory.createProduct();
        factory.createGift();
        factory = new FactoryB();
        factory.createProduct();
        factory.createGift();
    }
}