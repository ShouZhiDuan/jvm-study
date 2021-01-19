package com.demo.jvm.constant_test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/13 9:21
 * @Description: 字符串初始化内存分析
 * https://blog.csdn.net/weixin_42105936/article/details/112060398
 */
public class StringMainTest {

    public void  test0(){
        String s = "a" + "b";
       //String s1 = s + "c";
    }

    public void  test1(){
         String s = "";
         for (int i = 1; i < 10; i++){
             s = s + i;
         }
         System.out.println(s);
    }


    public static void  test2(){
        boolean equals = new String("abc").intern().equals("abc");
        System.out.println(equals);
    }

    public static void  test3(){
        int a = 1; //iconst_1压如操作数栈->istore 0 将操作数栈中的1弹出放到局部变量表第一个位置。
        int b = -1;
        int c = a + b;
        new String("abc");
    }


    public static void main(String[] args) {
         //test2();
        stringPoolTest();
    }

    /**
     *  string constant pool
     */

    public static void stringPoolTest(){
//        String s = new StringBuilder().append("计算机").append("软件").toString();
//        System.out.println(s.intern()==s);
//        String s1 = new StringBuilder().append("ja").append("va").toString();
//        System.out.println(s1.intern()==s1);

//        String aa = "aa";
//        String bb = new String("aa");
//        System.out.println(aa==bb);


//        String bbb = new String("aaa");
//        bbb.intern();
//        String aaa = "aaa";
//        System.out.println(aaa==bbb);

        //JDK1.8
//        String bbb = new String("aa") + new String("a");
//        bbb.intern();
//        String aaa = "aaa";
//        System.out.println(aaa==bbb);
//        String ccc = new String("aaa");
//        System.out.println(aaa==ccc);


        /**
         * ①、常量与常量的拼接结果是常量，它们在在常量池中完成。
         * ②、只要涉及到有变量的(非常量)，结果都是在堆内存中完成的。
         * ③、如果拼接后的结果调用了intern()方法，则返回值就是在常量池中。
         */
        //String bbb = String.valueOf("a") + String.valueOf("a");//不会推到常量池
        String bbb = String.valueOf("a");//不会推到常量池
        //String bbb = String.valueOf(1);//不会推到常量池

        //String bbb = new String("a") + "a";//不会推到常量池
        //String bbb = new String("a");//会推到常量池
        //bbb.intern();
        String aaa = "a";
        System.out.println(aaa==bbb);


//        String bbb = new String("a") + "a";//不会推到常量池
//        //String bbb = new String("a");//会推到常量池
//        bbb.intern();
//        String aaa = new String("aa");
//        System.out.println(aaa==bbb);



        //Integer integer1 = new Integer(10);
//        Integer integer1 = Integer.valueOf(10);
//        Integer integer = 10;
//        System.out.println(integer1==integer);


    }



}
