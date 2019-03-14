package com.ysj.concurrency.example.atomic;

import com.ysj.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
public class AtomicReference {

    private static final Logger logger = LoggerFactory.getLogger(AtomicReference.class);

    private static java.util.concurrent.atomic.AtomicReference count = new java.util.concurrent.atomic.AtomicReference(0);

    public static void main(String[] args){
        count.compareAndSet(0,2);
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        logger.info("count:{}",count.get());
    }
}
