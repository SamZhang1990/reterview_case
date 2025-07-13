package com.sam.zhang.multithread.pool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPool {

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(LocalDateTime.now() + ":" + name + " start to run");
                Thread.sleep(1000);
                System.out.println(LocalDateTime.now() + ":" + name + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService schxecutorService = Executors.newScheduledThreadPool(2);
        System.out.println(LocalDateTime.now() + ": main thread start to run");
        schxecutorService.schedule(new MyTask(), 2, TimeUnit.SECONDS);
        schxecutorService.schedule(new MyTask(), 4, TimeUnit.SECONDS);
        schxecutorService.schedule(new MyTask(), 8, TimeUnit.SECONDS);
        schxecutorService.shutdown();
    }
}
