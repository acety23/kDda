package com.kdda.designPatterns.creational.Factory.simpleFactory;

// 客户端代码
public class Main {
    public static void main(String[] args) {
        Product productA = SimpleFactory.createProduct("A");
        productA.use();

        Product productB = SimpleFactory.createProduct("B");
        productB.use();
    }
}
