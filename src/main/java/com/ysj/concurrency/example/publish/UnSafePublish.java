package com.ysj.concurrency.example.publish;

import com.ysj.concurrency.annoations.ThreadNotSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@ThreadNotSafe
public class UnSafePublish {

    private static final Logger logger = LoggerFactory.getLogger(UnSafePublish.class);

    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        logger.info("{}", Arrays.toString(unSafePublish.getStates()));

        unSafePublish.getStates()[0] = "d";
        logger.info("{}", Arrays.toString(unSafePublish.getStates()));
    }
}
