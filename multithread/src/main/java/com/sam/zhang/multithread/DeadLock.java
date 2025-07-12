package com.sam.zhang.multithread;

import static java.lang.Thread.sleep;

public class DeadLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    System.out.println(Thread.currentThread().getName() + " - locked A");
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + " - locked B");
                }
            }

        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                try {
                    System.out.println(Thread.currentThread().getName() + " - Locked B");
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + " - Locked A");
                }
            }

        }, "t2");

        t1.start();
        t2.start();

        //jps
//        samzhang@SamdeMacBook-Air interview_case % jps
//        66597 RemoteMavenServer36
//        98423 DeadLock
//        98422 Launcher
//        66537 Main
//        98430 Jps

        //jstack -l pid
//        samzhang@SamdeMacBook-Air interview_case % jstack -l 98423
//        "t1":
//        at com.sam.zhang.multithread.DeadLock.lambda$main$0(DeadLock.java:20)
//        - waiting to lock <0x000000069796b978> (a java.lang.Object)
//        - locked <0x000000069796b968> (a java.lang.Object)
//        at com.sam.zhang.multithread.DeadLock$$Lambda/0x000003e001003548.run(Unknown Source)
//        at java.lang.Thread.runWith(java.base@24/Thread.java:1460)
//        at java.lang.Thread.run(java.base@24/Thread.java:1447)
//        "t2":
//        at com.sam.zhang.multithread.DeadLock.lambda$main$1(DeadLock.java:36)
//        - waiting to lock <0x000000069796b968> (a java.lang.Object)
//        - locked <0x000000069796b978> (a java.lang.Object)
//        at com.sam.zhang.multithread.DeadLock$$Lambda/0x000003e001003780.run(Unknown Source)
//        at java.lang.Thread.runWith(java.base@24/Thread.java:1460)
//        at java.lang.Thread.run(java.base@24/Thread.java:1447)
//
//        Found 1 deadlock.

        //jconsole.exe
//  /Users/samzhang/software/openjdk-24.0.1/Contents/Home/bin/jconsole

        //Java VisualVM(Not found)
//        /Users/samzhang/software/openjdk-24.0.1/Contents/Home/bin/jvisualvm

    }
}
