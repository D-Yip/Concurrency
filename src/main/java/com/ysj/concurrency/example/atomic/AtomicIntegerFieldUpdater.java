package com.ysj.concurrency.example.atomic;

import com.ysj.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
public class AtomicIntegerFieldUpdater {

    private static final Logger logger = LoggerFactory.getLogger(AtomicIntegerFieldUpdater.class);

    private static java.util.concurrent.atomic.AtomicIntegerFieldUpdater updater =
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdater.class,"count");

    private volatile int count = 100;

    private static AtomicIntegerFieldUpdater example5 = new AtomicIntegerFieldUpdater();

    public static void main(String[] args){
        if (updater.compareAndSet(example5,100,120)){
            logger.info("update success 1,{}",example5.getCount());
        }

        if (updater.compareAndSet(example5,100,120)){
            logger.info("update success 2,{}",example5.getCount());
        }else {
            logger.info("update failed,{}",example5.getCount());
        }
    }

    public int getCount() {
        return count;
    }
}
