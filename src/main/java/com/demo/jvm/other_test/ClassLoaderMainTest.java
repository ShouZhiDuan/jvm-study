package com.demo.jvm.other_test;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/4 15:43
 * @Description:
 */
public class ClassLoaderMainTest {


    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader.getClass());
        //不同的实例器对应的class对象是同一个，但是必须是同一个类加载器。
        ClassLoaderMainTest test = new ClassLoaderMainTest();
        Class<? extends ClassLoaderMainTest> aClass = test.getClass();
        ClassLoaderMainTest test1 = new ClassLoaderMainTest();
        Class<? extends ClassLoaderMainTest> bClass = test1.getClass();
        System.out.println(aClass == bClass);
        System.out.println(test1.getClass().getName());
        System.out.println(test1.getClass().getSimpleName());
    }


}
