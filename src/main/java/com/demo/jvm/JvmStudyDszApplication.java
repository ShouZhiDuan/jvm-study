package com.demo.jvm;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.SpringFactoriesLoader;

@SpringBootApplication
public class JvmStudyDszApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JvmStudyDszApplication.class, args);
        SpringApplication springApplication = new SpringApplication(JvmStudyDszApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
