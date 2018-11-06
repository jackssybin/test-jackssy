package com.qding.test.jvm;
/**
 * 测试方法区中的静态变量引用的对象作为GCRoots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 * 扩展：方法区存与堆一样,是各个线程共享的内存区域,用于存放已被虚拟机加载的类信息,常量,静态变量,即时编译器编译后的代码等数据。
 * */
public class TestGCRoots02 {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;

    private static TestGCRoots02 t;

    public TestGCRoots02(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        TestGCRoots02 t2 = new TestGCRoots02(4 * _10MB);
        t2.t = new TestGCRoots02(8 * _10MB);
        t2 = null;
        System.gc();
    }
}
