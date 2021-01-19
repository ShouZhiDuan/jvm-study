package com.demo.jvm.other_test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 13:57
 * @Description:
 */
public class A {

    public void classLoad(){
        System.out.println("A.classLoad");
        findClass();
    }


    public void findClass(){
        //throw new RuntimeException("A.findClass");
    }

}
