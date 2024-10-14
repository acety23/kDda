package com.kdda.designPatterns.behavioral.strategy.demo2;

public enum StrategyEnum {
    A {
        @Override
        public void exe() {
            System.out.println("执行具体策略A");
        }

    },
    B {
        @Override
        public void exe() {
            System.out.println("执行具体策略B");
        }

    };

    public abstract void exe();
}
