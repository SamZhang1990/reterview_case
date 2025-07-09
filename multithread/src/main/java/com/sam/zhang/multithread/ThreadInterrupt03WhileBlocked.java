package com.sam.zhang.multithread;

import java.time.LocalDateTime;

public class ThreadInterrupt03WhileBlocked {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now() + " " + "...running...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        System.out.println("t1 status:" + t1.isInterrupted());
    }
}
