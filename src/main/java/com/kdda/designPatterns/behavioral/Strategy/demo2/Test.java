package com.kdda.designPatterns.behavioral.Strategy.demo2;

public class Test {
    public static void main(String[] args) {
        StrategyEnum strategy = StrategyCollection.map.get("A");
        strategy.exe();
    }
}
