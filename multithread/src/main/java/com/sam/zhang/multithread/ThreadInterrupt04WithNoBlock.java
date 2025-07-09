package com.sam.zhang.multithread;

public class ThreadInterrupt04WithNoBlock {
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interruptd = current.isInterrupted();
                if (interruptd) {
                    System.out.println("t2 interrupt status: " + interruptd);
                    break;
                }
            }
        }, "t2");
        t2.start();
        Thread.sleep(500);
        t2.interrupt();
    }

}
