package com.qding.test.calc;

public class MathTest {
    public static  String[] expres=new String[]{
            "(0*1--3)-5/-4-(3*(-2.13))",
            "-7+2*3",
            "1/0",
            "5/3"
    };
    public static void main(String[] args) {
        String expression = "(0*1--3)-5/-4-(3*(-2.13))AA";
        double result =0d;
        for(String str :expres){
//            expression=str;
            result = Calculator.conversion(expression);
            System.out.println(expression + " = " + result);
            System.out.println();
        }

//        String expression = "(0*1--3)-5/-4-(3*(-2.13))";
//        double result = Calculator.conversion(expression);
//        System.out.println(expression + " = " + result);
//        System.out.println();
    }

}