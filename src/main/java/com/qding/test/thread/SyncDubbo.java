package com.qding.test.thread;


/**
 * 一、Synchronized锁重入
 *
 * （1）关键字Synchronized拥有锁重入的功能，也就是在使用Synchronized的时候，当一个线程得到一个对象的锁后，在该锁里执行代码的时候可以再次请求该对象的锁时可以再次得到该对象的锁。
 *
 * （2）也就是说，当线程请求一个由其它线程持有的对象锁时，该线程会阻塞，而当线程请求由自己持有的对象锁时，如果该锁是重入锁,请求就会成功，否则阻塞。
 *
 * （3）一个简单的例子就是：在一个Synchronized修饰的方法或代码块的内部调用本类的其他Synchronized修饰的方法或代码块时，是永远可以得到锁的，示例代码A如下：
 *
 * ：自己可以获取自己的内部锁。
 */
public class SyncDubbo {

    public synchronized void method1() {
        System.out.println("method1-----");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2-----");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3-----");
    }

    public static void main(String[] args) {
        final SyncDubbo syncDubbo = new SyncDubbo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                syncDubbo.method1();
            }
        }).start();
    }
}
