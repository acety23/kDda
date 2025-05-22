package com.kdda;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        System.out.println(dog instanceof Dog);
//
//        System.out.println("Hello world!");
//        List<String> list = new ArrayList<>();
//        List<String> collect = list.stream().map(i -> i + "").collect(Collectors.toList());
//        System.out.println(collect);
//
//        Integer d = new Integer(8);
//        String jsonString = JSONObject.toJSONString(null);
//        System.out.println(jsonString);

        Map<String, Object> map = new HashMap<>();
        List<Dog> list = new ArrayList<>();
        map.put("list", list);
        System.out.println(map);
        List<Dog> dogs = new ArrayList<>();
        Dog dog = new Dog();
        dogs.add(dog);
        list = dogs;
        System.out.println(map);
        map.put("list", dogs);
        System.out.println(map);
    }





}

class Animal {
    String name;
    int age;
}
class Dog extends Animal {
    void bark() {
        System.out.println("wang");
    }
}