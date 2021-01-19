package com.demo.jvm.classloader_path;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 14:18
 * @Description:
 */
public class LoaderPathTest {

    /**
     *  关于class以及class_loader的getResource的区别。
     *  class.getResource如果括号中是以"/"开头的则会在classPath路劲下寻找资源，如果不是"/"开头默认从当前class相同包路劲寻找资源。
     *  classLoader.getResource直接从classPath路劲下寻找。所以当前情况是不能以"/"开头的，否则会返回null。
     */
    public static void main(String[] args) throws IOException {
        URL resource = LoaderPathTest.class.getResource("/application.properties");
        URL resource1 = LoaderPathTest.class.getResource("/");
        System.out.println(resource);
        System.out.println(resource1);
        InputStream in = LoaderPathTest.class.getResourceAsStream("/application.properties");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = in.read(bytes)) != -1){
            System.out.println(new String(bytes));
        }
        URL loaderResource = LoaderPathTest.class.getClassLoader().getResource("/");
        System.out.println(loaderResource);
    }




}
