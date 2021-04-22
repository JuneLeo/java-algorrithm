package com.algorithm.sample.sqlite;

public class SqliteDemo {
    public static void main(String[] args) {
        //sqlite中的锁
        // 1.unlock     没有锁
        // 2.shared     多个连接可以同时获得并保持共享锁
        // 3.reserved   写操作首先获取保留锁，不能阻止shared锁的读取，也不能阻止获取其他连接获取shared锁
        // 4.pending    准备写入操作，阻止其他连接获取锁，但是不能阻止正在进行中的shared锁，会等到进行中的shared锁释放
        // 4.exclusive  排它锁，进行写操作
        // 事务类型begin开始的锁状态
        // 1.DEFERRED   unlock     读读
        // 2.MMEDIATE   reserved   写写
        // 3.EXCLUSIVE  exclusive  读写


    }
}
