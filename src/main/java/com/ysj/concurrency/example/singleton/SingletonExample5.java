package com.ysj.concurrency.example.singleton;

import com.ysj.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式-->双重同步锁单例模式
 */
@ThreadSafe
public class SingletonExample5 {

    //volatile+双重检测机制->禁止指令重排
    private static volatile SingletonExample5 instance = null;

    private SingletonExample5(){

    }

    //1.memory = allocate()分配对象内存空间
    //2.ctorInstance()初始化对象
    //3.instance = memory 设置instance指向刚分配的内存

    //JVM和CPU优化，发生了指令重排，导致双重检测机制不再好用，可能有线程安全问题
    //通过volatile限制代码发生指令重排
    //maybe：
    //1.memory = allocate()分配对象内存空间
    //3.instance = memory 设置instance指向刚分配的内存
    //2.ctorInstance()初始化对象

    public static SingletonExample5 getInstance(){
        if (instance == null){
            synchronized (SingletonExample5.class){
                if (instance == null) instance = new SingletonExample5();
            }
        }
        return instance;
    }
}
