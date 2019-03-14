package com.ysj.concurrency.example.publish;

import com.ysj.concurrency.annoations.NotRecommend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NotRecommend
public class Escape {

    private static final Logger logger = LoggerFactory.getLogger(UnSafePublish.class);

    private int thisCanBeEscape = 0;

    public Escape() {
        new innerClass();
    }

    private class innerClass {

        public innerClass(){
            logger.info("YES====={}",Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
