package com.qding.test.valid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;

import static jdk.nashorn.internal.objects.Global.print;

public class ArrayTest {

    public static void main(String[] args){
        String[] array = new String[]{"arr","brr","crr"};
        java.util.List list = Arrays.asList(array);
        System.out.println(list.get(0));
        array[0]="ddddd";
        System.out.println(list.get(0));
//        list.add("111");
//        System.out.println(list.get(0));

        Map map = new HashMap<>();
        map.put("a","1");
        map.put("ab","2");
        map.put("abc","3");
        map.forEach((k,v) -> System.out.println(k+" ="+v));
        System.out.println("=============================");
        LongAdder longAddr = new LongAdder();
        System.out.println(longAddr);
        longAddr.add(1);
        System.out.println(longAddr);

        new Thread(() -> {
            System.out.println("12");
        }).start();



    }
}
