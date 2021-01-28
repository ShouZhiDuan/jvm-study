package com.demo.jvm.controller;

import com.demo.jvm.heap_stack_metaspace_over.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/1/28 20:01
 * @Description:
 */
@RestController
@RequestMapping("/jvm")
public class JvmTestController {


    @GetMapping("/heap")
    public void testHeapOver(){
        List<Person> list=new ArrayList<>();
        while(true){
            list.add(new Person());
        }
    }


}
