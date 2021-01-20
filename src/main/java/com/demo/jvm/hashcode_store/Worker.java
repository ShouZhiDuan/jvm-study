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
//@Data
public class Worker {
    //构造函数中作为初始入口，所以这种情况是不润许出现，否则出现StackOverflowError。
    //private Worker worker1 = new Worker(1);
    private static Integer staticAge = 30;
    private final static Integer finalStaticAge = 31;
    private final  Integer finalAge = 32;
    private static Integer nullAge;

    @Getter @Setter
    private int age;

    Worker(int age){
       this.age = age;
    }

    public static void main(String[] args) {
        Worker worker = new Worker(2);
        String s = ClassLayout.parseInstance(worker).toPrintable();
        System.out.println(s);//输出当前对象各模块的大小。
        System.out.println(worker.hashCode());//当前类的hashcode值。
    }
}
