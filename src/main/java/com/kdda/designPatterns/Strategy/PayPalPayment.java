package com.kdda.designPatterns.Strategy;

// 具体策略：PayPal支付
public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
