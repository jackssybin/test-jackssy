package com.qding.test.calc.abstrafactory;

import com.qding.test.calc.abstracttest.Product;

public class FactoryB implements FactoryAB {

    @Override
    public Product createProduct()
    {
        return new ProductB();
    }
}
