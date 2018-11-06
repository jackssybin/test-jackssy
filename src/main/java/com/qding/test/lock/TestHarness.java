package com.qding.test.lock;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束的倒数锁
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }



    public static void main(String[] args){
        TestHarness ts = new TestHarness();
//        ts.timeTasks(2,)
    }
}