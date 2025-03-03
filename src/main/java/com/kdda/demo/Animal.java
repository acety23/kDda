package com.kdda.demo;

abstract class Animal {
    String name;  // 可以有实例变量

    public Animal(String name) {
        this.name = name;
    }

    // 抽象方法
    public abstract void makeSound();

    // 具体方法
    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Kobe");
        dog.makeSound();
        dog.sleep();
    }
}
