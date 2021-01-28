package com.demo.jvm.java_reference;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/26 10:49
 * @Description:对象的生命周期：创建、使用、不可见、不可达、收集、终结、空间重分配。
 */
public class RefrenceMainTest {

    private static RefrenceMainTest refrenceMainTest = new RefrenceMainTest();


    public static RefrenceMainTest getRefrenceMainTest(){
        return refrenceMainTest;
    }

    public static void main(String[] args) {

    }

    /**
     * 强引用
     */
    public void strongRefrence(){
        //强应用 直接明了
        Object object = new Object();
        RefrenceMainTest.getRefrenceMainTest();
    }

}
