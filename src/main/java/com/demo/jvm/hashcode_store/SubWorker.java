package com.demo.jvm.hashcode_store;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/20 13:44
 * @Description:
 */
public class SubWorker extends Worker {

    private int d = 3;

    public static void main(String[] args) {
        Worker worker = new SubWorker();
        String s = ClassLayout.parseInstance(worker).toPrintable();
        System.out.println(s);//输出当前对象各模块的大小。
        System.out.println(worker.hashCode());//当前类的hashcode值。
    }
}
