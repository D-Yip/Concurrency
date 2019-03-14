package com.ysj.concurrency.example.atomic;

import com.ysj.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class AtomicBoolean {

    private static final Logger logger = LoggerFactory.getLogger(AtomicBoolean.class);

    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static java.util.concurrent.atomic.AtomicBoolean isHappened = new java.util.concurrent.atomic.AtomicBoolean(false);

    public static void main(String[] args) throws Exception {

        //定义一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                }catch (Exception e){
                    logger.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        logger.info("isHappened:{}",isHappened.get());
    }

    private static void test(){
        if (isHappened.compareAndSet(false,true)){
            logger.info("execute");
        }
    }
}
