package com.kdda.stringTest;

import org.junit.Test;

public class StringTest {
    @Test
    public void mainTest1(){
        long startTime1 = System.currentTimeMillis();
        StringBuilder str1 = new StringBuilder("start");
        for (int i = 0;i < 100000; i++){
            str1.append(i);
        }
        long endTime1 = System.currentTimeMillis();
        long time1 = endTime1 - startTime1;
        System.out.println("StringBuilder所花时间：" + time1);
        String str2 = "start";
        long startTime2 = System.currentTimeMillis();
        for (int i = 0;i < 100000; i++){
            str2 = str2 + i;
        }
        long endTime2 = System.currentTimeMillis();
        long time2 = endTime2 - startTime2;
        System.out.println("String++所花时间：" + time2);

    }

    @Test
    public void test2() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1$");
        String s = stringBuffer.toString();
        System.out.println(s);
        String[] split = s.split("$");
        System.out.println(split.length);
        for (String string : split) {
            System.out.println(string);
        }

    }
}
