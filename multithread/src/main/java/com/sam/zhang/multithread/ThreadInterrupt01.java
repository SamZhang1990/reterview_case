package com.sam.zhang.multithread;

public class ThreadInterrupt01 extends Thread {
    volatile boolean flag = false;
    @Override
    public void run() {
        while ( !flag ) {
            try {
                System.out.println(Thread.currentThread().getName() + "...running...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt01 t1 = new ThreadInterrupt01();
        t1.start();

        Thread.sleep(6000);

        //change the flag to true
        t1.flag = true;

    }
}
