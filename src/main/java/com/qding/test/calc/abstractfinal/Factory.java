package com.qding.test.calc.abstractfinal;

import com.qding.test.calc.abstracttest.Product;

public interface Factory {
    public Product createProduct();
    public Gift createGift();

}