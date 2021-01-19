package com.demo.jvm.java_spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/1/19 10:56
 * @Description:
 * 要是先SPI机制，必须要在ClassPath下创建一个META-INF.Services目录。
 * 然后在META-INF.Services目录下创建一个文件，该文件名为需要被实现的接口全限定名，
 * 然后里面写上实现类的全限定名，多个实现换行写入就好了。
 */
public class SpiMainTest {
    /**
     * SPI动态类加载测试
     */
    public static void main(String[] args) {
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()){
            iterator.next().syaHello();
        }
    }
}
