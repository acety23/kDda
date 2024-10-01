package com.kdda.designPatterns.creational.Factory.factoryMethod;

// 具体工厂类B
public class ProductBFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
