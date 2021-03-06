package com.demo.jvm.other_test;


import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 13:57
 * @Description:
 */
@Data
public class B extends A {

    private int b = 10;

    public B() {

    }

    /**
     * 如果父类方法被子类覆盖,后续无论是子类发起调用还是父类发起调用都是执行被覆盖的子类的实现方法。
     */
    @Override
    public void findClass() {
        System.out.println("B.findClass");
    }

    public static void main(String[] args) {
//        A a = new B();
//        a.a = 20;
//        a.classLoad();
//        System.out.println(a.a);
//        String s = new String();
//        System.out.println(s.getClass().getClassLoader());
//
//        ClassLoader cl = Thread.currentThread().getContextClassLoader();
//        System.out.println(cl);
//        B b = new B();
//        System.out.println(JSON.toJSONString(b));

        int ordinal = Stage.HIGH.ordinal();
        System.out.println(Stage.values()[ordinal].getText());


    }


}


