package com.sam.zhang.multithread;

import java.util.Objects;

public class WaitNotifyTest {
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "...be awoken...");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "...be woken...");
            }
        }, "t2");

        t1.start();
        t2.start();

        Thread.sleep(2000);
        synchronized (lock) {
//            lock.notify();
            lock.notifyAll();
        }

    }
}
