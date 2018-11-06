package com.qding.test.zhengtai;

import java.math.BigDecimal;

public class DoubleUtil {

    /**
     * 加法运算
     *
     * @param m1
     * @param m2
     * @return
     */

    public static double add(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.add(p2).doubleValue();
    }

    /**
     * 减法运算
     *
     * @param m1
     * @param m2
     * @return
     */


    public static double sub(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param m1
     * @param m2
     * @return
     */


    public static double mul(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.multiply(p2).doubleValue();
    }

    /**
     * 除法运算
     *
     * @param m1
     * @param m2
     * @param scale
     * @return
     */


    public static double div(double m1, double m2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
//  double result = add(1.00000000000000001, 1.00000000000000001);
//  //result = 2.0 丢失了精度
//  System.out.println(result);

        int a = 3;
        double b = 0.03;
        double c = 0.03;
        //不会丢失精度
        double d = add(add(a, b), c);
        System.out.println("first d:" + d);
        //会丢失精度
        d = a + b + c;
        System.out.println("second d:" + d);

    }
}
