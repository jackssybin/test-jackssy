package com.qding.test.thread;


/**
 * 出现异常时，锁自动释放
 */
public class SyncException {

    private int i = 0;

    public synchronized void operation() {
        while (true) {
            i++;
            System.out.println(Thread.currentThread().getName() + " , i= " + i);
            if (i == 10) {
                Integer.parseInt("a");
            }
        }
    }

    public static void main(String[] args) {
        final SyncException se = new SyncException();
        new Thread(new Runnable() {
            public void run() {
                se.operation();
            }
        }, "t1").start();
    }
}
