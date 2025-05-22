package com.kdda.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestInstanceOf {
    public static void main(String[] args) {
        List<String> strList= new ArrayList<>();
        System.out.println(strList instanceof List);


        System.out.println(JSONObject.toJSONString(null));
        System.out.println(JSONObject.parse(null) + "1");
        String s = null;
        System.out.println(s + "1");
        System.out.println(JSONObject.parseObject("null", Map.class));

    }
}
