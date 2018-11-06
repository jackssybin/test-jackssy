package com.qding.test.calc.breakfirstfactory;


/**
 * Created by Olive on 2017/12/20.
 * 所有早餐的基类
 */
public class BreakfastShop implements Breakfast{

    @Override
    public void sell() {
        System.out.println("卖早餐了！！！");
    }
}
