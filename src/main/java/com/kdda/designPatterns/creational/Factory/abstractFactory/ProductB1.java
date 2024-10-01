package com.kdda.designPatterns.creational.Factory.abstractFactory;

// 具体产品类B1
public class ProductB1 implements ProductB {
    @Override
    public void use() {
        System.out.println("Using Product B1");
    }
}
