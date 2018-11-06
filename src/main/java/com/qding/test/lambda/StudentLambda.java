package com.qding.test.lambda;

import java.util.*;

public class StudentLambda {

    public static  void main(String[] args){
            List<Student> studentList = new ArrayList<Student>(){
                {
                    add(new Student("stu1",100.0));
                    add(new Student("stu2",97.0));
                    add(new Student("stu3",96.0));
                    add(new Student("stu4",95.0));
                }
            };
            Collections.sort(studentList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Double.compare(o1.getScore(),o2.getScore());
                }
            });

        Collections.sort(studentList,(s1,s2)-> Double.compare(s1.getScore(),s2.getScore()));
            System.out.println(studentList);

        new Thread(()->{System.out.println("hello, i am thread!");
            System.out.println("hello, i am thread!");}).start();


        List<String> strLst = new ArrayList<String>() {
            {
                add("adfkjsdkfjdskjfkds");
                add("asdfasdfafgfgf");
                add("public static void main");
            }
        };
        Collections.sort(strLst, String::compareToIgnoreCase);
        System.out.println(strLst);
        System.out.println("----------------------");
        strLst.forEach(e -> System.out.println(e));

    }
}
