package com.demo.jvm.constant_test;

import java.util.*;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/13 17:23
 * @Description:
 */
public class AllMainTest {
      public static AllMainTest allMainTest = new AllMainTest();
//    public int i;
//    public int intA = 1;
//    public static int staticIntA = 2;
//    public static Integer staticIntegerA = 22;
//    public final static int finalsStaticIntA = 3;
//
//    public double d;
//    public double doubleA = 6;
//    public static double staticDoubleA = 7;
//    public static Double staticDoubleDoubleA = 7d;
//    public final static double finalStaticDoubleA = 8;
//
//
//    public String string;
//    public String stringValue = "666666";
//    public static String staticStringValue = "777777";
//    public final static String finalStaticStringValue = "888888";
//
//    public String string1 = new String("111");
//    public String string2 = String.valueOf("22");

    public void test() {
        AllMainTest mainTest = new AllMainTest();
        String mString = "123456";
        int mInt = 1234567;
        String mAaa = new String("aaa");
        String mBbb = "bbb";
        String mCcc = String.valueOf("ccc");
        String mDdd = String.valueOf("ddd") + String.valueOf("eee");
        String mDff = String.valueOf(987654321);
        double doubleA = 666666;
    }

    public static void test1() {
        double doubleA = 666666;
        double doubleB = 666666;
        System.out.println(doubleA==doubleB);
    }

    public static void test2() {
        Double doubleA = 666666d;
        Double doubleB = 666666d;
        System.out.println(doubleA==doubleB);
    }

    public static void main(String[] args) {
//        test2();
//        test1();
        List<Integer> arrayLists = Collections.<Integer>emptyList();
        arrayLists.add(1);
//        ArrayList<Object> objects = new ArrayList<>();
//        objects.add(2);
        //List list2 = Collections.emptyList();
        System.out.println();


        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());


    }

}
