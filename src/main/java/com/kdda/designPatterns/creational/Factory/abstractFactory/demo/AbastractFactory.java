package com.kdda.designPatterns.creational.Factory.abstractFactory.demo;

public abstract class AbastractFactory {
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
