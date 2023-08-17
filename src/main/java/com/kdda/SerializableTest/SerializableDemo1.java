package com.kdda.SerializableTest;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 使用java内置序列化机制实现对象的序列化以及反序列化
 *
 * @author baijiechong
 * @since 2023/5/6 23:49
 **/
public class SerializableDemo1 {

    private static final String FILE_PATH = "javaTest";

    public static void main(String[] args) {
        final User user = new User();
        user.setName("baijiechong");
        user.setAge(22);
        //序列化
        SerializableDemo1 demo1 = new SerializableDemo1();
        demo1.serialization(user);
        //反序列化
        demo1.deserialization();
    }

    /**
     * 序列化
     * @param user 序列化的对象
     */
    public void serialization(User user) {
        ObjectOutputStream oos = null;
        try {
            OutputStream outputStream = Files.newOutputStream(Paths.get(FILE_PATH));
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //org.apache.tomcat.util.http.fileupload.IOUtils
            IOUtils.closeQuietly(oos);
        }
    }

    /**
     * 反序列化
     */
    public void deserialization() {
        File file = new File(FILE_PATH);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
            try {
                //org.apache.tomcat.util.http.fileupload.FileUtils
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
