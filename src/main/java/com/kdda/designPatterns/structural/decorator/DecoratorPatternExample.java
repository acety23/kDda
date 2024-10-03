package com.kdda.designPatterns.structural.decorator;

// 抽象组件：饮料接口
interface Beverage {
    String getDescription();
    double cost();
}

// 具体组件：一种具体饮料，基础咖啡
class Coffee implements Beverage {
    public String getDescription() {
        return "Coffee";
    }

    public double cost() {
        return 2.0;
    }
}

// 抽象装饰器：装饰器类，持有一个饮料对象
abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription();
    }

    public double cost() {
        return beverage.cost();
    }
}

// 具体装饰器：添加牛奶
class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double cost() {
        return beverage.cost() + 0.5;
    }
}

// 具体装饰器：添加糖
class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    public double cost() {
        return beverage.cost() + 0.2;
    }
}

// 使用装饰器
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Beverage beverage = new Coffee();  // 基础咖啡
        beverage = new MilkDecorator(beverage);  // 添加牛奶
        beverage = new SugarDecorator(beverage);  // 添加糖

        System.out.println(beverage.getDescription() + " $" + beverage.cost());
    }
}
