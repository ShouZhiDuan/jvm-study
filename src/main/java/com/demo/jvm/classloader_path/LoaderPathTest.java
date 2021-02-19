package com.demo.jvm.classloader_path;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 14:18
 * @Description:
 */
public class LoaderPathTest {

    /**
     *  ClassPath资源获取
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


    /**
     *  磁盘资源
     */
    @Test
    public void test() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        File file = new File("D:\\test-class");
        URL url = file.toURI().toURL();
        URLClassLoader myClassLoader = new URLClassLoader(
                new URL[] { url }, Thread.currentThread().getContextClassLoader());
        Class<?> aClass = myClassLoader.loadClass("packTest.LoaderTest");
        Object o = aClass.getConstructor().newInstance();
        Method method = aClass.getMethod("test", null);
        method.invoke(o,null);
    }


    /**
     * jar包
     */
    public void test2(){
        try {
            File file = new File("rtest.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s = new String();
            while ((s = in.readLine()) != null) {
                //从rtest.txt中读取的url，根据url创建类装载器
                URL url = new URL(s);
                s = null;
                URLClassLoader myClassLoader = new URLClassLoader(
                        new URL[] { url }, Thread.currentThread().getContextClassLoader());
                System.out.println(myClassLoader);
                Class myClass = myClassLoader.loadClass("uRLClassLoaderTest1.TestAction");
                Object action = myClass.newInstance();
                //String str = action.action();
                //System.out.println(str);

                //根据url1创建类装载器
                URL url1 = new URL("file:d:/test.jar");
                URLClassLoader myClassLoader1 = new URLClassLoader(
                        new URL[] { url1 }, Thread.currentThread().getContextClassLoader());
                Class myClass1 = myClassLoader1.loadClass("uRLClassLoaderTest1.TestAction");
                Object action1 =  myClass1.newInstance();
                //String str1 = action1.action();
                //System.out.println(str1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * test
     */
    @Test
    public void test3(){
        //System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("sun.cpu.isalist"));
        Map<String, String> getenv = System.getenv();
        Properties properties = System.getProperties();
        System.out.println();
    }




















}
