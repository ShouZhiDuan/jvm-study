package com.demo.jvm.my_classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/19 10:45
 * @Description:
 */
public class MyUrlClassLoader extends URLClassLoader {


    public MyUrlClassLoader(URL[] urls) {
        super(urls);
    }


    public MyUrlClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }







}
