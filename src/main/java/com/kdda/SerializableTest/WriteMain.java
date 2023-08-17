package com.kdda.SerializableTest;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteMain {
    public static void main(String[] args) {
        final User user = new User();
        user.setName("baijiechong");
        user.setAge(22);
//        user1.setHeight(1.98);
        ObjectOutputStream oos = null;
        try {
            //序列化
            OutputStream outputStream = Files.newOutputStream(Paths.get("FILE_PATH"));
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //org.apache.tomcat.util.http.fileupload.IOUtils
            IOUtils.closeQuietly(oos);
        }
    }
}
