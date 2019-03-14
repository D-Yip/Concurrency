package com.ysj.concurrency.example.aqs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class FutureExample {

	private static final Logger logger = LoggerFactory.getLogger(FutureExample.class);

	static class MyCallable implements Callable<String>{

	    private static final Logger logger = LoggerFactory.getLogger(MyCallable.class);

		@Override
		public String call() throws Exception {
			logger.info("do something in callable");
			Thread.sleep(5000);
			return "Done";
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        logger.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        logger.info("result->{}",result);
	}
}
