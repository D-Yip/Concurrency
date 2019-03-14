package com.ysj.concurrency.example.singleton;

import com.ysj.concurrency.annoations.NotRecommend;
import com.ysj.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private static SingletonExample3 instance = null;

    private SingletonExample3(){

    }

    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
