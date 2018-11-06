package com.qding.test.calc.breakfirstfactory;


/**
 * Created by Olive on 2017/12/20.
 * 甘其食高级早餐工厂
 */
public class AdvBreakfastFactory implements BreakfastFactory {

    @Override
    public Breakfast sellBuns() {
        return new ExpensiveBuns();
    }

    @Override
    public Breakfast sellSoyMilk() {
        return new ExpensiveSoyMilk();
    }
}