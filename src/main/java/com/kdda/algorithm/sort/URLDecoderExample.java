package com.kdda.algorithm.sort;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderExample {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 构建一个包含非法URL编码字符的字符串
        String illegalEncodedString = "%gg";

        // 尝试解码非法字符串
        try {
            String decodedString = URLDecoder.decode(illegalEncodedString, "UTF-8");
            System.out.println("Decoded string: " + decodedString);
        } catch (IllegalArgumentException e) {
            System.out.println("Error decoding: " + e.getMessage());
            e.printStackTrace();
        }

        // 尝试对一个正常字符串进行编码
        String normalString = "Hello World";
        String encodedString = URLEncoder.encode(normalString, "UTF-8");
        System.out.println("Encoded string: " + encodedString);
    }
}
