package com.qding.test.calc.abstractfinal;

import com.qding.test.calc.abstracttest.Product;
import com.qding.test.calc.abstrafactory.ProductB;

public class FactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
    @Override
    public Gift createGift() {
        return new GiftB();
    }

}