package com.demo.jvm.heap_stack_metaspace_over;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/22 13:10
 * @Description:
 */
@Data
public class Person {
    private int age;
    private String name;

    public Person() {
        //System.out.println("人类");
    }

    static class XiaoMing extends Person{
        public static void main(String[] args) {
              new XiaoMing();
        }
    }
}
