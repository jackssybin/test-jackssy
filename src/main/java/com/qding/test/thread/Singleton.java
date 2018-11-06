package com.qding.test.thread;

/**
 * 单例模式-双重校验锁
 */
public class Singleton {

    private static Singleton instance = null; //懒汉模式
    //private static Singleton instance = new Singleton(); //饿汉模式

    private Singleton() {

    }

    public static synchronized Singleton newInstance() {
        if (null == instance) { //判断实例是否已经被其他线程创建了
            instance = new Singleton();
        }
        return instance;
    }
}
