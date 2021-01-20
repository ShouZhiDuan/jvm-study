package com.demo.jvm.hashcode_store;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 19:33
 * @Description:
 */
@Data
public class Worker {
    private static Integer staticAge = 30;
    private final static Integer finalStaticAge = 31;
    private final  Integer finalAge = 32;
    private static Integer nullAge;

    public static void main(String[] args) {
        /**
         * JVM Options：
         *    -XX:-UseCompressedOops关闭压缩指针
         *    -XX:+UseCompressedOops开启压缩指针
         * 指针压缩：
         *    4G < Mem(heap) < 32G 默认开启指针压缩。
         *    Mem(heap) < 4G 关闭指针压缩。
         *    Mem(heap) > 32G 指针压缩失效。
         */
        Worker worker = new Worker();
        String s = ClassLayout.parseInstance(worker).toPrintable();
        System.out.println(s);//输出当前对象各模块的大小。
        System.out.println(worker.hashCode());//当前类的hashcode值。
    }
}
