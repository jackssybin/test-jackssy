package com.qding.test.calc.abstractfinal;

import com.qding.test.calc.abstracttest.Product;
import com.qding.test.calc.abstrafactory.ProductA;

public class FactoryA implements Factory {
    @Override
    public Product createProduct()
    {
        return new ProductA();
    }
    @Override
    public Gift createGift()
    {
        return new GiftA();
    }
}