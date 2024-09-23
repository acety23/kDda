package com.kdda.designPatterns.Strategy;

// 具体策略：信用卡支付
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

