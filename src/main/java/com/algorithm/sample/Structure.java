package com.algorithm.sample;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class Structure {
    // arraylist
    // 1.add 时扩容，10个
    // 2.扩容最小为10, 后续扩容为 0.5倍
    // fast - fail机制，modCount，记录操作次数
    // 多线程使用Vector和CopyOnWriteArrayList
    // RandmoAccess > 对象直接遍历 > iterator
    // ArrayList 实现了RandmoAccess接口，即提供了随机访问功能


    // vector
    // 初始容量 10 ，扩容可以指定，否则1倍增加
    // RandmoAccess > Enumeration > for循环另一种遍历 > iterator
    // iterator 线程不安全
    //


    // LinkedList
    // 双向链表，可以是队列，又可以是栈
    // 不要用随机访问遍历，否则耗时会很长 ,get方法访问


    // Stack
    // 栈 pop peek push
    //


    // HashMap
    // 加载因子 0.75f 阈值
    //


    // HashTable
    // 线程安全
    //


    // WeakHashMap
    // 使用了弱引用和引用队列

    // 引用
    // 强引用，软引用(内存不够用触发回收)，弱引用（GC时触发回收），虚引用（创建就消失）

    // 线程相关

    // 计算机中使用补码，因为做运算的时候，补码做加法减法时很方便。



}
