package com.sam.zhang.multithread;

import java.time.LocalDateTime;

public class ThreadInterrupt02 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(LocalDateTime.now() + Thread.currentThread().getName() + "...running...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt02 t2 = new ThreadInterrupt02();
        t2.start();

        Thread.sleep(6000);
        t2.stop();
    }
}
