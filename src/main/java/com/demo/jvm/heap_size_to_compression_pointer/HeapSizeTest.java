package com.demo.jvm.heap_size_to_compression_pointer;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/20 16:09
 * @Description:
 */
public class HeapSizeTest {

    /**
     * you can to see https://kknews.cc/code/k4peavv.html
     * 为了在jvm运行过程中，在堆尽可能大的时候使用指针压缩。减少内存浪费，提高对象实际存储空间，有利于GC。
     * 那么到底HeapSize要设置多少呢？
     * 用如下命令进行探测：
     *   java -Xmx32766m -XX:+PrintFlagsFinal 2> /dev/null | grep UseCompressedOops
     */
    public static void main(String[] args) {

    }





}
