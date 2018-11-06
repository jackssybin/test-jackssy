package com.qding.test.zhengtai;

import org.apache.commons.math3.fitting.GaussianCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class ZhengtaiTest {

    public double normalRandom1(double a, double b) {
        //注意这里的b是方差，等于标准差的平方
        double temp = 12;
        double x = 0;
        for (int i = 0; i < temp; i++) x = x + (Math.random());
        x = (x - temp / 2) / (Math.sqrt(temp / 12));
        x = a + x * Math.sqrt(b);
        return x;
    }

    public double normalRandom2(double a, double b) {
        double pi = 3.1415926535;
        double r1 = Math.random();
        Math.random();
        Math.random();
        Math.random();
        Math.random();
        Math.random();
        Math.random();
        Math.random();
        double r2 = Math.random();
        double u = Math.sqrt((-2) * Math.log(r1)) * Math.cos(2 * pi * r2);
        double z = a + u * Math.sqrt(b);
        return (z);
    }

    public double normalRandom3(double a, double b) {
        double f = 0;
        double c0 = 2.515517, c1 = 0.802853, c2 = 0.010328;
        double d1 = 1.432788, d2 = 0.189269, d3 = 0.001308;
        double w;
        double r = Math.random();
        if (r <= 0.5) w = r;
        else w = 1 - r;
        if ((r - 0.5) > 0) f = 1;
        else if ((r - 0.5) < 0) f = -1;
        double y = Math.sqrt((-2) * Math.log(w));
        double x = f * (y - (c0 + c1 * y + c2 * y * y) / (1 + d1 * y + d2 * y * y + d3 * y * y * y));
        double z = a + x * Math.sqrt(b);
        return (z);
    }

    public double normalRandom(double a, double b) {
        double r = Math.random() * 9;
        switch ((int) r / 3) {
            case 0:
                return normalRandom1(a, b);
            case 1:
                return normalRandom2(a, b);
            case 2:
                return normalRandom3(a, b);
        }
        return 0.0;
    }



    private static void genZhengTai() {
        double zhengtai0_1;
        java.util.Random r=new java.util.Random();
        for (int i = 0; i< 20;i++) {
            zhengtai0_1 = r.nextGaussian();
            System.out.println(zhengtai0_1);
        }
    }

    public static void testZhengTai(){
        WeightedObservedPoints obs = new WeightedObservedPoints();
      /*  obs.add(0, 25);
        obs.add(1, 68);
        obs.add(2, 144);
        obs.add(3, 220);
        obs.add(4, 335);
        obs.add(5, 199);
        obs.add(6, 52);
        obs.add(7, 14);
        obs.add(8, 5);
        obs.add(9, 2);*/
        obs.add(0,1);
        obs.add(1,2);
        obs.add(2,3);
        obs.add(3,4);
        obs.add(4,5);
        obs.add(5,6);
        obs.add(6,7);
        obs.add(7,8);
        obs.add(8,9);

        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
        for (double i : parameters) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        genZhengTai();
        testZhengTai();
    }



}
