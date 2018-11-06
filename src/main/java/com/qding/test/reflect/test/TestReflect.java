package com.qding.test.reflect.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestReflect {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException{
        QdingBodyT<GetBodyRequest> test222 = new QdingBodyT<GetBodyRequest>();

        System.out.println("tttt=222");

        GetBodyRequest test = new GetBodyRequest();
        Field[] fields= GetBodyRequest.class.getGenericSuperclass().getClass().getFields();
        for(Field field :fields){
            System.out.println(field.getName()+" type="+field.getType());
        }

//        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
//            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
//                System.out.print(t1 + ",");
//            }
//            System.out.println();
//        }

    }
}
