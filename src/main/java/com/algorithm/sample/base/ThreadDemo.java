package com.algorithm.sample.base;

public class ThreadDemo {

    static String[] events = {"A", "B", "C", "D", "E", "F", "G", "H"};
    

    public static void main(String[] args) {
        new Thread(new Runnable() {
            boolean stop = false;
            int index = 0;
            @Override
            public void run() {
                while (!stop) {
                    if (index < events.length) {
                        System.out.println(Thread.currentThread().getName() + events[index]);
                        index += 3;
                    } else {
                        stop = true;
                    }

                }
            }
        }, "1").start();

        new Thread(new Runnable() {
            boolean stop = false;
            int index = 1;

            @Override
            public void run() {
                while (!stop) {
                    if (index < events.length) {
                        System.out.println(Thread.currentThread().getName() + events[index]);
                        index += 3;
                    } else {
                        stop = true;
                    }

                }
            }
        }, "2").start();
        new Thread(new Runnable() {
            boolean stop = false;
            int index = 2;
            @Override
            public void run() {
                while (!stop) {

                    if (index < events.length) {
                        System.out.println(Thread.currentThread().getName() + events[index]);
                        index += 3;
                    } else {
                        stop = true;
                    }

                }
            }
        }, "3").start();



    }

}
