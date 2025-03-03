package com.kdda.collection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>  </p>
 *
 * @author tiyong
 * @date 21/10/2024 11:09
 */
public class Test {

    public static void main(String[] args) throws Throwable {
        Class<String> stringClass = String.class;
        String s = stringClass.getDeclaredConstructor().newInstance();
        stringClass.newInstance();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        lookup.findConstructor(String.class, MethodType.methodType(void.class)).invoke();
    }
}
