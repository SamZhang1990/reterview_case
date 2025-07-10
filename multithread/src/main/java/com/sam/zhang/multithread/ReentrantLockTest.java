package com.sam.zhang.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    //create the lock object
    static ReentrantLock lock = new ReentrantLock();
    //condition 1
    static Condition c1 = lock.newCondition();
    //condition 2
    static Condition c2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        //Lock to interrupt
//        lockInterrupt();

        //Lock to time out
//        lockTimeout();

        //Lock to different conditions
        lockCondition();
    }

    private static void lockCondition() {
        new Thread(() -> {
            try {
                lock.lock();
                c1.await();
                System.out.println(Thread.currentThread().getName() + ", got the lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                c1.await();
//                c2.await();
                System.out.println(Thread.currentThread().getName() + ", Got the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            try {
                lock.lock();
                //random wake up one thread under c1
//                c1.signal();
                //wake up all thread under c1
                c1.signalAll();
//                c2.signal();
                System.out.println(Thread.currentThread().getName() + ", Got the lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3").start();
    }

    private static void lockTimeout() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println("t1 Failed to get lock");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("t1 Got the lock");
            } finally {
                lock.unlock();
            }

        }, "t1");

        lock.lock();
        System.out.println("Main thread got the lock");
        t1.start();

        try {
            Thread.sleep(3000);
        } finally {
            lock.unlock();
        }

    }

    private static void lockInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Interrupt while waiting");
                return;
            }

            try {
                System.out.println(Thread.currentThread().getName() + ", got the lock");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        System.out.println("Main thread got the lock");
        t1.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("performing the interrupt");
        } finally {
            lock.unlock();
        }
    }

}
