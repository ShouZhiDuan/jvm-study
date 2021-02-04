package com.demo.jvm.other_test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/2/4 20:03
 * @Description:
 */
public class TestServiceImpl implements TestService {
    @Override
    public void print() {
        System.out.println("my name is SpringBoot SPI");
    }
}
