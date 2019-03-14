package com.ysj.concurrency.example.singleton;

import com.ysj.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonExample2 {

    private static SingletonExample2 instance = new SingletonExample2();

    private SingletonExample2(){

    }

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
