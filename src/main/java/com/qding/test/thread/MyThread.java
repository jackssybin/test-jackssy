package com.qding.test.thread;

public class MyThread extends Thread {

    private int count = 5;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName() + " count:" + count);
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        Thread thread3 = new Thread(myThread, "thread3");
        Thread thread4 = new Thread(myThread, "thread4");
        Thread thread5 = new Thread(myThread, "thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
