package com.kdda.designPatterns.creational.Singleton;

/**
 * <p>  </p>
 * 双重检查锁：在懒汉式的基础上优化，避免了每次获取实例时都进行同步。
 * @author tiyong
 * @date 24/09/2024 11:17
 */
public class DoubleCheckLocking {
    private static DoubleCheckLocking doubleCheckLocking;

    private DoubleCheckLocking() {
    }

    private DoubleCheckLocking getInstance() {
        if (doubleCheckLocking == null) {
            synchronized (DoubleCheckLocking.class) {
                if (doubleCheckLocking == null) {
                    doubleCheckLocking = new DoubleCheckLocking();
                }
            }
        }
        return doubleCheckLocking;
    }
}
