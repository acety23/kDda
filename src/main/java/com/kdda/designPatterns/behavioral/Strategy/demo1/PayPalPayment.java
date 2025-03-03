package com.kdda.designPatterns.behavioral.Strategy.demo1;

// 具体策略：PayPal支付
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
