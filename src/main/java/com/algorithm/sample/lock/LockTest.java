package com.algorithm.sample.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    static class BlockedMutex {
        private Lock lock = new ReentrantLock();


        public BlockedMutex() {
            this.lock.lock();// mian线程持有了这个锁
            System.out.println(Thread.currentThread().getName());
        }


        public void f() {
            try {
                this.lock.lockInterruptibly();// 如果当前线程未被中断则获取锁
                System.out.println("lock acquired in f()");
            } catch (InterruptedException e) {
                System.out.println("Interrupted from lock acquisition in f()");
            }
        }
    }


    static class Blocked2 implements Runnable {
        BlockedMutex blocked = new BlockedMutex();
        @Override
        public void run() {
            System.out.println("Waiting for f() in BlockedMutex");
            this.blocked.f();
            System.out.println("Broken out of blocked call");
            System.out.println(Thread.currentThread().getName());
        }


    }


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}

