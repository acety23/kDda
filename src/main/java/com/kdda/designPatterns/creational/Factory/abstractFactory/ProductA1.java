package com.kdda.designPatterns.creational.Factory.abstractFactory;

// 具体产品类A1
public class ProductA1 implements ProductA {
    @Override
    public void use() {
        System.out.println("Using Product A1");
    }
}
