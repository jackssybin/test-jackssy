package com.qding.test.calc.breakfirstfactory;



/**
 * Created by Olive on 2017/12/20.
 * 旺比低级早餐工厂
 */
public class LowBreakfastFactory implements BreakfastFactory {

    public Breakfast sellBuns() {
        return new CheapBuns();
    }

    public Breakfast sellSoyMilk() {
        return new CheapSoyMilk();
    }
}