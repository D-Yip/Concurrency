package com.ysj.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.ysj.concurrency.annoations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//        map.put(1,3);
//        map.put(6,6);
        System.out.println(map.toString());
    }
}
