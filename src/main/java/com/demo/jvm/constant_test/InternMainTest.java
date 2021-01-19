package com.demo.jvm.constant_test;

import java.util.Random;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/13 16:25
 * @Description:
 */
public class InternMainTest {
    static int test=0;
    static final int MAX = 1000 * 10000;
    static final String[] arr = new String[MAX];
    public static void main(String[] args) throws Exception {
        Integer[] DB_DATA = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < DB_DATA.length; i++) {
            DB_DATA[i] = random.nextInt();
        }
        long t = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length]));
            //arr[i] = new String(String.valueOf(DB_DATA[i % DB_DATA.length])).intern();
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }

    String aaa = new String("aaa");
    String bbb = "bbb";
    String ccc = String.valueOf("ccc");
    String ddd = String.valueOf("ddd") + String.valueOf("eee");
    String fff = String.valueOf(1);

    public void  testpool(){
        String aaaaaa = new String("aaaaaa");
        String bbbbbb = "bbbbbb";
        String cccccc = String.valueOf("cccccc");

    }


}
