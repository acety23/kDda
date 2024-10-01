package com.kdda.designPatterns.creational.Factory.abstractFactory;

// 抽象工厂接口
public interface AbstractFactory {
    ProductA createProductA();

    ProductB createProductB();
}
