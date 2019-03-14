package com.ysj.concurrency.example.singleton;

import com.ysj.concurrency.annoations.ThreadNotSafe;

/**
 * 懒汉模式
 */
@ThreadNotSafe
public class SingletonExample1 {

    private static SingletonExample1 instance = null;

    private SingletonExample1(){

    }

    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
