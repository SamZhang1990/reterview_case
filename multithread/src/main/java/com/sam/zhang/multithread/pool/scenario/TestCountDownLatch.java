package com.sam.zhang.multithread.pool.scenario;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(LocalDateTime.now() + ":" + name + " start to run");
                Thread.sleep(1000);
                System.out.println(LocalDateTime.now() + ":" + name + " completed to run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }, "t1").start();

        new Thread(() -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(LocalDateTime.now() + ":" + name + " start to run");
                Thread.sleep(1500);
                System.out.println(LocalDateTime.now() + ":" + name + " completed to run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }, "t2").start();

        new Thread(() -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(LocalDateTime.now() + ":" + name + " start to run");
                Thread.sleep(1000);
                System.out.println(LocalDateTime.now() + ":" + name + " complete to run");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            latch.countDown();
        }, "t3").start();

        String name = Thread.currentThread().getName();
        System.out.println(LocalDateTime.now() + ":" + name + ": start to run");
        latch.await();
        System.out.println(LocalDateTime.now() + ":" + name + ": completed to run");
    }
}
