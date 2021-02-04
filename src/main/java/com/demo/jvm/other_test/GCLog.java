package com.demo.jvm.other_test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/1 19:41
 * @Description:
 */
public class GCLog {
    /**
     * -Xmx10M -Xms10M -verbose:gc -XX:+PrintGCDetails  -XX:+PrintHeapAtGC  -Xloggc:ggc.log
     * @param args
     * 1、查看当前jvm采用的垃圾回收器是什么,开启了哪些参数？
     * java -XX:+PrintFlagsFinal -version | grep :查看全局默认的
     * java -XX:+PrintCommandLineFlags -version
     *
     */
    public static void main(String[] args) {
        Map map = new HashMap<>();
        int a = 0;
        while (true){
            byte[] b = new byte[100];
            map.put(a++,b);
            if(a%1000==0){
                System.gc();
            }
        }
    }
}
