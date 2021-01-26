package com.demo.jvm.heap_stack_metaspace_over;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/22 9:28
 * @Description:
 */
public class HeapStackMetaspaceOver extends ClassLoader{




    public static void main(String[] args) {
            //heapOver(); //堆溢出
            stackOver(); //栈溢出
            //metaspaceOver(); //元空间溢出
    }


    /**
     * 分配堆空间
     * -Xmx20M -Xms20M
     * 堆溢出
     */
    public static void  heapOver(){
        List<Person> list=new ArrayList<>();
        while(true){
            list.add(new Person());
        }
    }

    private static int stackCount = 0;

    /**
     * 分配栈空间
     * -Xss200k
     * 栈溢出
     * -Xss200kB表示当前jvm中栈最大的存储空间，由于栈是线程的独占空间，所以相当于一个线程最多分配200k的内存活动空间。
     * 如果系统分配给内存500MB=500*1024KB=512000KB/200KB=2560个线程并发执行。
     * 但是经验值一般系统线程在3000-5000这个数量。
     * 按照最大5000来分析：5000*200KB=1000000KB/1024=976MB
     */
    public static void  stackOver(){
            stackCount++;
            System.out.println(stackCount);
            stackOver();
    }



    /**
     * 元空间溢出
     */
    public static List<Class<?>>  metaspaceOver(){
        /**
         * 动态编写java类文件
         * 动态编译java文件
         * defineClass加载最终的class文件
         * loaderClass findClass(toByteArray) defineClass
         */
        List<Class<?>> classes = new ArrayList<>();
            for (int i = 0; i < 10000000; ++i) {
                    ClassWriter cw = new ClassWriter(0);
                    cw.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                    MethodVisitor mw = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
                    mw.visitVarInsn(Opcodes.ALOAD, 0);
                    mw.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object","<init>", "()V");
                    mw.visitInsn(Opcodes.RETURN);
                    mw.visitMaxs(1, 1);
                    mw.visitEnd();
                    HeapStackMetaspaceOver test = new HeapStackMetaspaceOver();
                    byte[] code = cw.toByteArray();
                    Class<?> exampleClass = test.defineClass("Class" + i, code, 0, code.length);
                    classes.add(exampleClass);
            }
            return classes;
    }

}
