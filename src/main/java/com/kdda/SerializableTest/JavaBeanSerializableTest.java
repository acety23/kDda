package com.kdda.SerializableTest;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author baijiechong
 * @since 2023/5/21 18:56
 **/
public class JavaBeanSerializableTest {
    public static void main(String[] args) throws JsonProcessingException {
        //定义一个Model类型的对象
        final Model model = new Model();
        model.setSuccess(true);

        //使用fastjson(v1.2.16) 序列化model为字符串输出
        System.out.println("Serializable result with fastjson : " + JSON.toJSONString(model));

        //使用Gson(v2.8.5) 序列化model为字符串输出
        Gson gson = new Gson();
        System.out.println("Serializable result with gson : " + gson.toJson(model));

        //使用jackson(v2.9.7) 序列化model为字符串输出
        ObjectMapper om = new ObjectMapper();
        System.out.println("Serializable result with jackson : " + om.writeValueAsString(model));
    }
}
