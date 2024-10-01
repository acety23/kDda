package com.kdda.designPatterns.creational.Factory.simpleFactory;

// 具体产品类A
public class ProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}
