package com.qding.test.calc.breakfirstfactory;


/**
 * Created by Olive on 2017/12/20.
 */
public class Client {

    public static void main(String[] args){

        // 进入高级早餐店买一个包子
        BreakfastFactory breakfastFactory = new AdvBreakfastFactory();
        Breakfast breakfast = breakfastFactory.sellBuns();
        breakfast.sell();

        // 去低级早餐店买一包豆浆
        BreakfastFactory breakfastFactory2 = new LowBreakfastFactory();
        Breakfast breakfast2 = breakfastFactory2.sellSoyMilk();
        breakfast2.sell();
    }
}