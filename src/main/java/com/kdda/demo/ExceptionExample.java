package com.kdda.demo;

import java.io.IOException;

public class ExceptionExample {
    public static void main(String[] args) {
        // 示例：处理已检查异常
        try {
            throwCheckedException();
        } catch (IOException e) {
            System.out.println("Caught an IOException: " + e.getMessage());
        }

        // 示例：处理未检查异常
        try {
            throwUncheckedException();
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }
    }

    public static void throwCheckedException() throws IOException {
        throw new IOException("This is a checked exception.");
    }

    public static void throwUncheckedException() {
        String str = null;
        System.out.println(str.length()); // 这里会抛出 NullPointerException
    }
}
