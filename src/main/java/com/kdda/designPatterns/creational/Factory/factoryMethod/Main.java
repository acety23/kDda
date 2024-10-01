package com.kdda.designPatterns.creational.Factory.factoryMethod;

// 客户端代码
public class Main {
    public static void main(String[] args) {
        ProductFactory factoryA = new ProductAFactory();
        Product productA = factoryA.createProduct();
        productA.use();

        ProductFactory factoryB = new ProductBFactory();
        Product productB = factoryB.createProduct();
        productB.use();
    }
}
