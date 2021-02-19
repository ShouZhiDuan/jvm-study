package com.demo.jvm.my_classloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/19 10:45
 * @Description: https://www.iteye.com/topic/136427
 */
public class MyUrlClassLoader extends URLClassLoader {


    public MyUrlClassLoader(URL[] urls) {
        super(urls);
    }


    public MyUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public Class load(String name) throws ClassNotFoundException {
        return load(name, false );
    }

    public Class load(String name, boolean resolve) throws ClassNotFoundException {
        if ( null != super .findLoadedClass(name)) return reload(name, resolve);
        Class clazz = super .findClass(name);
        if (resolve) super .resolveClass(clazz);
        return clazz;
    }

    public Class reload(String name, boolean resolve) throws ClassNotFoundException {
        return new MyUrlClassLoader(super.getURLs(), super.getParent()).load(name, resolve);
    }



    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyUrlClassLoader classLoader = new MyUrlClassLoader(new URL[]{new URL("file:/C:/Users/dev/Desktop/test/")});
        Class<?> aClass = classLoader.load("test.LoaderTest");
        Object instance = aClass.newInstance();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/C:/Users/dev/Desktop/test/")});
        new File("").toURI().toURL();
        System.out.println();
    }
}
