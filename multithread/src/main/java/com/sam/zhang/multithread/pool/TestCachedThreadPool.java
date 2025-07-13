package com.sam.zhang.multithread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {
    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "...running end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0; i<10; i++) {
            executorService.submit(new MyTask());
            Thread.sleep(1);
        }
        executorService.shutdown();
    }
}
