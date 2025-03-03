package com.kdda.designPatterns.behavioral.Strategy.demo1;

// 上下文类，持有一个策略的引用
public class PaymentContext {
    private PaymentStrategy strategy;

    // 允许客户端设置不同的支付策略
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    // 执行支付
    public void pay(int amount) {
        strategy.pay(amount);
    }
}
