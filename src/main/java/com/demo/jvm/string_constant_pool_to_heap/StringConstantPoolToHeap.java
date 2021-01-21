package com.demo.jvm.string_constant_pool_to_heap;


import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/21 16:58
 * @Description:
 */
public class StringConstantPoolToHeap {

    /**
     * -Xms3m -Xmx3m -XX:+PrintGCDetails
     * 将堆大小设置小一点，然后答应出gc日志，看堆的大小情况。
     * 出现：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (long i = 0; i < 20000; i++) {
            //把数字转成字符串类型，然后放入到字符串常量池中
            //list.add(String.valueOf(i).intern());
            list.add(String.valueOf(i));
        }
    }

}



