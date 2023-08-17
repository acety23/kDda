package com.kdda.SerializableTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SingletonSerializableTest {

//    private static final String FILE_PATH = "H:\\user\\desktop\\serialization.txt";
    
    public static void main(String[] args) {
        try {
            //通过代码获取到单例对象
            final Singleton init = Singleton.init();
            Path path = Paths.get("SINGLETON");
            //将单例对象序列化到文件
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
            oos.writeObject(init);
            oos.close();
            //通过文件反序列化出Singleton
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
            Singleton sl = (Singleton) ois.readObject();
            ois.close();
            System.out.println("result : " + (init == sl));
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
