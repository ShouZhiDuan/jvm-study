package com.demo.jvm.serializable_test;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/19 16:39
 * @Description:
 */
@Data
public class Person implements Serializable {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
