package com.kdda.designPatterns.creational.Factory.simpleFactory;

// 工厂类
public class SimpleFactory {
    public static Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ProductA();
        } else if ("B".equals(type)) {
            return new ProductB();
        }
        throw new IllegalArgumentException("Unknown product type");
    }
}
