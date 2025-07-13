package com.sam.zhang.multithread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleThreadPool {
    static int count;
    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "...Start with " + count);
                Thread.sleep(100);
                System.out.println(name + "...End with " + count);
                count++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0; i<10; i++) {
            System.out.println("");
            executorService.submit(new MyTask());
        }
        executorService.shutdown();
    }
}
