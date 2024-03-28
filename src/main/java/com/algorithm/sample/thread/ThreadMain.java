package com.algorithm.sample.thread;

public class ThreadMain {
    // yield 线程让步，所有线程抢锁资源
    // sleep 不会释放锁 wait会
    // join可以保证 被join的线程执行完成，再继续往下执行
    // 线程池策略
    // 1.CallerRunsPolicy 在调用的线程中执行任务
    // 2.AbortPolicy  抛出异常
    // 3.DiscardPolicy 啥也不做
    // 4.DiscardOldestPolicy poll一个头部的任务，放入一个老任务
    // 死锁条件：互斥；请求与保持；不可剥夺；循环等待
    // LinkedBlockingQueue和ArrayBlockingQueue中take和put的区别，前者put和take是两把锁
    // ConcurrentHashMap vaule和key不能为空

    // Queue 提供了（add,offer)(remove,poll)(element,peek)
    // BlockingQueue 继承Queue，提供了（add,offer,put,offer(time)),(remove,poll,take,poll(time))




    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    if(Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    System.out.println("thread - " + i);
                }

            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                thread.interrupt();
            }
        });
        thread2.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finish");
    }
}
