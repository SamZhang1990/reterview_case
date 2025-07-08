package com.sam.zhang.multithread;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.time.LocalDateTime;

public class WaitSleepTest {
    static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
//        illegalWait();
//        waiting();
        sleeping();
    }

    private static void sleeping() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(LocalDateTime.now() + "..." + Thread.currentThread().getName() + "...sleeping...");
                    Thread.sleep(5000L);
                    System.out.println(LocalDateTime.now() + "..." + Thread.currentThread().getName() + "...running...end...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t2");
        t2.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            System.out.println(LocalDateTime.now() + "...other threads running...");
        }
    }

    private static void waiting() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println(LocalDateTime.now() + "..." + Thread.currentThread().getName() + "...waiting...");
                try {
                    LOCK.wait(5000L);
                    System.out.println(LocalDateTime.now() + "..." + Thread.currentThread().getName() + "...running...end...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "t1");
        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            System.out.println(LocalDateTime.now() + "..." + Thread.currentThread().getName() + "...other threads...");
        }
    }

    private static void illegalWait() throws InterruptedException {
        LOCK.wait();
    }
}
