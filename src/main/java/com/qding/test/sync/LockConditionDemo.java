package com.qding.test.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        LockConditionDemo demo = new LockConditionDemo();

        new Thread(() -> demo.await(demo.conditionA), "thread1_conditionA").start();
        new Thread(() -> demo.await(demo.conditionB), "thread2_conditionB").start();
        new Thread(() -> demo.signal(demo.conditionA), "thread3_conditionA").start();
        System.out.println("稍等5秒再通知其他的线程！");
        Thread.sleep(5000);
        new Thread(() -> demo.signal(demo.conditionB), "thread4_conditionB").start();

    }

    private void await(Condition condition) {
        try {
            lock.lock();
            System.out.println("开始等待await！ ThreadName：" + Thread.currentThread().getName());
            condition.await();
            System.out.println("等待await结束！ ThreadName：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal(Condition condition) {
        lock.lock();
        System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }
}

