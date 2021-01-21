package com.demo.jvm.hashcode_store;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/20 16:39
 * @Description:
 */
public class ListTest {


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            integers.add(Integer.valueOf(i));
        }
        String s = ClassLayout.parseInstance(integers).toPrintable();
        System.out.println(s);//输出当前对象各模块的大小。
        System.out.println(integers.hashCode());//当前类的hashcode值。
    }




}
