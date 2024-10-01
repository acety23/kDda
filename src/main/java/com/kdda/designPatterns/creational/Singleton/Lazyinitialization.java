package com.kdda.designPatterns.creational.Singleton;

/**
 * 懒汉式：在需要时才创建实例，避免不必要的开销，但需要考虑线程安全。
 * @author tiyong
 * @date 24/09/2024 10:53
 */
public class Lazyinitialization {
    private Lazyinitialization() {

    }

    private static Lazyinitialization lazyinitialization;

    public static synchronized Lazyinitialization getInstance() {
        if (lazyinitialization == null) {
            return new Lazyinitialization();
        }
        return lazyinitialization;
    }
}
