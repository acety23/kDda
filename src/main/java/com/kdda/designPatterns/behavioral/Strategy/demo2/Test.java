package com.kdda.designPatterns.behavioral.strategy.demo2;

public class Test {
    public static void main(String[] args) {
        StrategyEnum strategy = StrategyCollection.map.get("A");
        strategy.exe();
    }
}
