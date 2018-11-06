package com.qding.test.calc.abstracttest;

public class Factory {
    //可以在工厂类中添加任何你所需要的逻辑
    public static Product create(String str)
    {
        //生成ProductA
        if(str.equalsIgnoreCase("ProductA"))
        {
            return new ProductA();
        }
        else
            //生成ProductB
            if(str.equalsIgnoreCase("ProductB"))
            {
                return new ProductB();
            }
        return null;
    }

}