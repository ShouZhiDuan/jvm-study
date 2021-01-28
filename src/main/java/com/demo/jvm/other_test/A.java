package com.demo.jvm.other_test;

import java.math.BigDecimal;

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
//          Integer a = 120;
//          Integer b = 1000;
//          int c = 120;
//          System.out.println(a==b);
//          System.out.println(a==c);
//        BigDecimal a = new BigDecimal(3.971288);
//        BigDecimal b = new BigDecimal(-2.029648);
//        BigDecimal subtract = a.subtract(b);


//        Double aDouble = Double.valueOf(3.971288);
//        Double bDouble = Double.valueOf(-2.029648);
//        double v = aDouble - bDouble;

        Float aFloat = Float.valueOf("3.971288");
        Float bFloat = Float.valueOf("-2.029648");
        float v1 = aFloat - bFloat;

        System.out.println();


    }

}
