package com.demo.jvm.other_test;

import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/4 16:21
 * @Description:
 */
public class FileMainTest {

    @Test
    public void tet() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.demo.jvm.other_test.FileMainTest");
        System.out.println(aClass);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        URL resource = FileMainTest.class.getResource("/");
        File file = new File(resource.getPath());
        //String prefix = "E:\\dsz-git-work\\jvm-study-dsz\\target\\classes";
        String prefix = file.getPath()+"\\";
        printFileName(file, prefix);
    }

    static int a = 0;

    public static void printFileName(File file, String prefix) throws ClassNotFoundException {
        if (file.isDirectory()) {
            System.out.println(++a);
            System.out.println("这是一个目录：" + file.getName());
            File[] files = file.listFiles();
            for (File print : files) {
                printFileName(print, prefix);
            }
        } else {
            if (file.getName().contains(".class")) {
                String prefixile = file.getPath().replace(prefix,"").replaceAll("\\\\",".");
                String substring = prefixile.substring(0, prefixile.lastIndexOf(".class"));
                System.out.println(Class.forName(substring));
            }
        }
    }


}
