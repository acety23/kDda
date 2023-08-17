package com.kdda.SerializableTest;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;

public class ReadMain {
        public static void main(String[] args) {
        File file = new File("FILE_PATH");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            User user = (User) ois.readObject();
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
//            try {
//                FileUtils.forceDelete(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
