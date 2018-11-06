package com.qding.test.thread;

public class StringLock {

    private String lock = "lock";

    public void method() {
        synchronized (lock) {
            try {
                System.out.println("当前线程： " + Thread.currentThread().getName() + "开始");
                Thread.sleep(1000);
                System.out.println("当前线程： " + Thread.currentThread().getName() + "结束");
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        new Thread(new Runnable() {
            public void run() {
                stringLock.method();
            }
        }, "t1").start();

        new Thread(new Runnable() {
            public void run() {
                stringLock.method();
            }
        }, "t2").start();
    }
}
