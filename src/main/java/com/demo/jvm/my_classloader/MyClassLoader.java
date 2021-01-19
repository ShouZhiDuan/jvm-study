package com.demo.jvm.my_classloader;

import lombok.Setter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 10:10
 * @Description:
 */
public class MyClassLoader extends ClassLoader{

    @Setter
    private String root;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            /**真正意思获取class对象的方法*/
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        /**class文件路劲*/
        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1){
                baos.write(buffer,0,length);
            }
            /**将class文件转换成字节数组*/
            return baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        myClassLoader.setRoot("E:\\temp");
        Class<?> aClass = myClassLoader.loadClass("test_pack.TestLoader");
        Method testDo = aClass.getMethod("main", String[].class);
        //注意这里调用main函数传入的string[]参数要转换成一个整体，否则会当期做多个参数拆开传入，出现wrong number of arguments
        testDo.invoke(null,(Object)new String[]{"123", "456"});
        System.out.println();
    }













}
