package com.demo.jvm.other_test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 13:57
 * @Description:
 */
public class A {

    public int a = 10;

    public void classLoad(){
        System.out.println("A.classLoad");
        findClass();
    }


    public void findClass(){
        int findClassInt = 10;
        //throw new RuntimeException("A.findClass");
    }

    public static void main(String[] args) {
          Integer a = 120;
          Integer b = 1000;
          int c = 120;
          System.out.println(a==b);
          System.out.println(a==c);
    }

}
