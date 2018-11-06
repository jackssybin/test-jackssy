package com.qding.test.calc.abstrafactory;

import com.qding.test.calc.abstracttest.Product;

public class FactoryA implements FactoryAB {

    @Override
    public Product createProduct()
    {
        return new ProductA();
    }
}
