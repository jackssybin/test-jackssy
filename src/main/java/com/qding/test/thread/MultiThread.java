package com.qding.test.thread;

public class MultiThread {

    private  static int num = 200;

    public   synchronized void printNum(String threadName, String tag) {
        if (tag.equals("a")) {
            num = num - 100;
            System.out.println(threadName + " tag a,set num over!");
        } else {
            num = num - 200;
            System.out.println(threadName + " tag b,set num over!");
        }
        System.out.println(threadName + " tag " + tag + ", num = " + num);
    }

    public static void main(String[] args) throws InterruptedException {
        final MultiThread multiThread1 = new MultiThread();
        final MultiThread multiThread2 = new MultiThread();

        new Thread(new Runnable() {
            public void run() {
                multiThread1.printNum("thread1", "a");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                multiThread2.printNum("thread2", "b");
            }
        }).start();
    }
}