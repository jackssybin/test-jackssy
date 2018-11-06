package com.qding.test.jvm;

/**
 * 测试常量引用对象作为GCRoots
 * 注意：t修饰符如果只是final会被回收，static final不会被回收，所以static final 才是常量的正确写法
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 */
public class TestGCRoots03 {
    private static int _10MB = 10 * 1024 * 1024;
    private static final TestGCRoots03 t = new TestGCRoots03(8 * _10MB);
    private byte[] memory;

    public TestGCRoots03(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        TestGCRoots03 t3 = new TestGCRoots03(4 * _10MB);
        t3 = null;
        System.gc();
    }
}
