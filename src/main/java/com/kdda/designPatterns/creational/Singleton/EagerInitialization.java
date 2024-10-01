package com.kdda.designPatterns.creational.Singleton;

/**
 * 饿汉式：在类加载时就创建实例，线程安全，但可能会造成资源浪费。
 * @author tiyong
 * @date 24/09/2024 11:02
 */
public class EagerInitialization {

    private static final EagerInitialization eagerInitialization = new EagerInitialization();
    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return eagerInitialization;
    }
}
