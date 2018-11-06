package com.qding.test.listremove;

import java.util.*;

public class ListRemoveTest {

    public static  void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
//正常循环
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i的值:" + i + " 对应的数字:" + list.get(i));
//        }
//        System.out.println("没有remove前list的项:"+list.size());

        for(Integer te:list){
            System.out.println("i的值:" + te + " 对应的数字:" + te);
            if(te==3){
                list.remove(te);
            }
        }

                System.out.println("==========remove后的list==========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("i的值  " + i + " 对应的数字 " + list.get(i));
        }

//边循环边删除
//        for (int i = list.size() -1 ; i >= 0; i--) {
//            System.out.println("i的值  " + i + " 对应的数字 " + list.get(i));
//            if(list.get(i) == 3) list.remove(list.get(i));
//        }
//        System.out.println("remove后list的项:"+list.size());
//
//        System.out.println("==========remove后的list==========");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i的值  " + i + " 对应的数字 " + list.get(i));
//        }

    }
}
