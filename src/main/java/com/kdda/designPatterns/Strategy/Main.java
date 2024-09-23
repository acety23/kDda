package com.kdda.designPatterns.Strategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // 使用信用卡支付
        context.setPaymentStrategy(new CreditCardPayment());
        context.pay(100);

        // 使用PayPal支付
        context.setPaymentStrategy(new PayPalPayment());
        context.pay(200);
    }
}
