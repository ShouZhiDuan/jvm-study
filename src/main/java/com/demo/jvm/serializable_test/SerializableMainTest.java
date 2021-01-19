package com.demo.jvm.serializable_test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 16:40
 * @Description:
 */
public class SerializableMainTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
         //serial();//序列化
         backSerial();//反序列化
    }

    //序列化
    public static void serial() throws IOException {
        Person person = new Person(30,"duanshouzhi");
        FileOutputStream outputStream = new FileOutputStream("Person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
    //反序列化
    public static void backSerial() throws IOException, ClassNotFoundException {
         FileInputStream inputStream = new FileInputStream("Person.txt");
         ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
         Person person = (Person) objectInputStream.readObject();
         objectInputStream.close();
         System.out.println(person.name);
    }

}
