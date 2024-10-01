package com.kdda.designPatterns.creational.Singleton;

/**
 * <p>  </p>
 * 单例模式可以通过枚举（Enum）来实现，这是 Java 中一种非常简洁且安全的方式。使用枚举实现单例模式的主要优点是线程安全和防止反序列化问题。
 * 特点：
 * 简洁性：通过定义一个枚举类型，代码非常简洁明了。
 * 线程安全：枚举类型在 Java 中是线程安全的，不需要额外的同步处理。
 * 防止反序列化：Java 在反序列化时会确保枚举类型只能有一个实例，这避免了反序列化攻击。
 * @author tiyong
 * @date 24/09/2024 11:25
 */
public enum Singleton {
    INSTANCE;

    public void someMethod() {

    }

//    使用方式：
//    你可以通过 Singleton.INSTANCE 来访问单例实例，例如：
    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTANCE;
        singleton.someMethod();
    }

}
