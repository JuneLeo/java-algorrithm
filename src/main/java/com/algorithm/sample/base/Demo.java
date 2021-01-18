package com.algorithm.sample.base;

public class Demo {
    // 一、类加载过程
    // 加载 - 验证 - 准备 - 解析 - 初始化 - 使用 - 卸载
    // 加载类全限定名 读取二进制字节流到方法区，将二进制转化为运行时数据结构
    // 验证 文件格式验证，元数据验证，字节码验证，符号引用验证
    // 准备 正式为类变量分配内存，并设置类变量初始值（方法区） 只包括static变量 下面a赋值0；b赋值2
    // 非final 赋值是ConstantValue = 0， final 赋值 ConstantValue = 2 ，ConstantValue在代码编译器进行的赋值
    public static int a = 1;
    public static final int b = 2;
    //解析 将常量池中的符号转化为直接引用的过程
    //初始化 即上述中将 a赋值1
    // 使用
    //卸载

//
//     二，初始化类的行为
//     new setstatic getstatic invokestatic
//     反射调用Class.forName
//     Const[] con = new Const[5];  不会被初始化

    //三，类初始化
    //静态方法（顺序执行）
    //1.类中常量，代码块（顺序执行） 2.构造方法
    //自上而下


    public static void main(String[] args) {
//        Class clz = Child.class;
//        Child.f();
//        try {
//            Class.forName(Child.class.getCanonicalName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Child.c);
    }
}
