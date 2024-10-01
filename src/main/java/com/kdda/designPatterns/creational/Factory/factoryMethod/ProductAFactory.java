package com.kdda.designPatterns.creational.Factory.factoryMethod;

// 具体工厂类A
public class ProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
