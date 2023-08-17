package com.kdda.SerializableTest;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = -8776688389222211831L;
    private static volatile Singleton singleton = null;

    private Singleton() {}

    public static Singleton init() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private Object readResolve() {
        return init();
    }
}
