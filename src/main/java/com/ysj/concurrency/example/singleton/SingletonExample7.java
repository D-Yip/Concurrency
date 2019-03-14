package com.ysj.concurrency.example.singleton;

import com.ysj.concurrency.annoations.Recommend;
import com.ysj.concurrency.annoations.ThreadSafe;


/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSYANCE.getInstance();
    }

    private enum Singleton{
        INSYANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
