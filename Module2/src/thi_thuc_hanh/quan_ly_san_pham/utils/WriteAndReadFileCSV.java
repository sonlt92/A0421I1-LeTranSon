package thi_thuc_hanh.quan_ly_san_pham.utils;

import java.io.*;
import java.util.Collection;


public class WriteAndReadFileCSV {
    public static void writeFile(Collection collection, String path) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(collection);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static Object readFile(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        Object object = null;

        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);

            object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
