package com.ysj.concurrency.example.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    private static final Logger logger = LoggerFactory.getLogger(FutureTaskExample.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        new Thread(futureTask).start();
        logger.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        logger.info("result->{}",result);
    }
}
