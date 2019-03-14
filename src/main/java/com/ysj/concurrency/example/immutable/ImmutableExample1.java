package com.ysj.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.ysj.concurrency.annoations.ThreadNotSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadNotSafe
public class ImmutableExample1 {

    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        map.put(1,3);
        System.out.println(map.toString());
    }

    private void test(final int a){

    }
}
