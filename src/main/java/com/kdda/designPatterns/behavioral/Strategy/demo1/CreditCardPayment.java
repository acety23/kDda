package com.kdda.designPatterns.behavioral.Strategy.demo1;

// 具体策略：信用卡支付
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

