package com.demo.jvm.java_reference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

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



    @Data
    public static class  SoftData{
        private String name;
        private Integer age;
        public SoftData(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    @Setter @Getter
    private SoftReference<SoftData> softReference;

    /**
     * 软引用
     */
    public void genSoftRefrence(){
         SoftData softData = new SoftData("dsz",30);
         softReference = new SoftReference(softData);
         softData = null;
         if(softReference != null){
             SoftData softDataCache = softReference.get();
             // softDataCache to do something
         }else {
             //GC内存不足的时候，可能被回收了。
             SoftData softNewData = new SoftData("dsz",30);
             softReference = new SoftReference(softData);
         }
    }


    /**
     * 弱引用
     */
    @Test
    public void genWeakRefrence() throws InterruptedException {
          byte[] cacheData = new byte[100*1024*1024]; //100M
          WeakReference<byte[]> cacheRef = new WeakReference<>(cacheData);
          System.out.println("第一次GC前" + cacheData);
          System.out.println("第一次GC前" + cacheRef.get());
          System.gc();//进行一次GC后查看对象的回收情况
          //等待GC
          Thread.sleep(500);
          System.out.println("第一次GC后" + cacheData);
          System.out.println("第一次GC后" + cacheRef.get());

          cacheData = null;
          System.gc();
          Thread.sleep(500);

          System.out.println("第二次GC后" + cacheData);
          System.out.println("第二次GC后" + cacheRef.get());
    }


}
