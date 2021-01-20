package com.demo.jvm.stack_over_flowe_rror;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/20 10:23
 * @Description:
 */
public class MyStackOverFlowError {
    /**
     * 从字节码分析：每个类在编译的时候都会存在<init>构造函数。见18行或者33行具体详情。
     * 从下面两种不停情况分析可知main中会执行new MyStackOverFlowError().在new的过程后会调用<init>。
     * 但是在类初始化非static修饰的属性都会默认放在<init>函数去做初始化赋值。
     * 所以private  MyStackOverFlowError error = new MyStackOverFlowError();会在main中new-><init>
     *  这样便出现了无限递归，导致StackOverFlowError。
     *
     *  关于类初始化属性初始化的规则。
     *  1、static修饰的全局属性,没有赋给初始化值。则不会在<clinit>函数进行初始化赋值。如果有赋给初始化值，则会在clinit函数中进行初始化赋值。
     *  2、非statis修饰的全局属性，没有赋给初始化值。则不会在<init>函数进行初始化赋值。如果有赋给初始化值，则会在init函数中进行初始化赋值。
     */
    private  MyStackOverFlowError error = new MyStackOverFlowError();

    public static void main(String[] args) {
        MyStackOverFlowError error = new MyStackOverFlowError();
    }

/*  没有定义：private  MyStackOverFlowError error = new MyStackOverFlowError();
    public <init>()V
    L0
    LINENUMBER 8 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
    RETURN
    L1
    LOCALVARIABLE this Lcom/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError; L0 L1 0
    MAXSTACK = 1
    MAXLOCALS = 1
*/



/*  有定义：private  MyStackOverFlowError error = new MyStackOverFlowError();
    public <init>()V
    L0
    LINENUMBER 8 L0
    ALOAD 0
    INVOKESPECIAL java/lang/Object.<init> ()V
    L1
    LINENUMBER 10 L1
    ALOAD 0
    NEW com/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError
    DUP
    INVOKESPECIAL com/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError.<init> ()V
    PUTFIELD com/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError.error : Lcom/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError;
    RETURN
    L2
    LOCALVARIABLE this Lcom/demo/jvm/stack_over_flowe_rror/MyStackOverFlowError; L0 L2 0
    MAXSTACK = 3
    MAXLOCALS = 1
*/

}
