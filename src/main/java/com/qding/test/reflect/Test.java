package com.qding.test.reflect;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.lang.reflect.ParameterizedType;

public class Test extends ClassA<String> {
    private List<String> list;
    private Map<String, Object> map;

    /***
     * 获取List中的泛型
     */
    public static void testList() throws NoSuchFieldException, SecurityException {
        Type t = Test.class.getDeclaredField("list").getGenericType();
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }

    /***
     * 获取Map中的泛型
     */
    public static void testMap() throws NoSuchFieldException, SecurityException {
        Type t = Test.class.getDeclaredField("map").getGenericType();
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws Exception {
//        System.out.println(">>>>>>>>>>>testList>>>>>>>>>>>");
//        testList();
//        System.out.println("<<<<<<<<<<<testList<<<<<<<<<<<\n");
        System.out.println(">>>>>>>>>>>testMap>>>>>>>>>>>");
        testMap();
        System.out.println("<<<<<<<<<<<testMap<<<<<<<<<<<\n");
//        System.out.println(">>>>>>>>>>>testClassA>>>>>>>>>>>");
//        new Test().testClassA();
//        System.out.println("<<<<<<<<<<<testClassA<<<<<<<<<<<");
    }


}
