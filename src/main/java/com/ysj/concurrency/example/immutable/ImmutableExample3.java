package com.ysj.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.ysj.concurrency.annoations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class ImmutableExample3 {

    private static final Logger logger = LoggerFactory.getLogger(ImmutableExample3.class);

    private static final ImmutableList list = ImmutableList.of(1,2,3,1,2);

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

//    private static final ImmutableMap<Integer,Integer> map = ImmutableMap.of(1,2,2,3,3,4);
    private static final ImmutableMap<Integer,Integer> map = ImmutableMap.<Integer,Integer>builder()
        .put(1,2).put(2,3).put(3,4).build();

    public static void main(String[] args) {
        map.forEach((k,v)->{
            logger.info("{}-{}",k,v);
        });
        System.out.println(list.toString());
        System.out.println(set.toString());
        System.out.println(map.toString());
    }
}
