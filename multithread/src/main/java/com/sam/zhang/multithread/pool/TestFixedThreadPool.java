package com.sam.zhang.multithread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
    static class Task implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i=0; i< 2; i++) {
                System.out.println(name + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i=0; i< 5; i++) {
            executorService.submit(new Task());
        }
        executorService.shutdown();
    }
}
