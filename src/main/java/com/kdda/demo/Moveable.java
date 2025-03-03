package com.kdda.demo;

interface Moveable {
    // 抽象方法（默认是 public abstract）
    void move();

    // Java 8 之后可以有默认方法
    default void stop() {
        System.out.println("Stopped.");
    }
}

class Car implements Moveable {
    @Override
    public void move() {
        System.out.println("Car is moving.");
    }
}

class Bicycle implements Moveable {
    @Override
    public void move() {
        System.out.println("Bicycle is moving.");
    }

    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.stop();
    }
}
