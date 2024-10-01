package com.kdda.designPatterns.creational.Factory.factoryMethod;

// 具体产品类B
public class ProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}
