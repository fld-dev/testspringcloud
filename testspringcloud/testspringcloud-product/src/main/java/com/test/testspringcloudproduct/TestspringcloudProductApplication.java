package com.test.testspringcloudproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

//这两个注解都是让eureka发现服务，并将服务注册到eureka上的注解
@EnableEurekaClient//相同点：都能让注册中心eureka发现，并将服务注册到eureka
@EnableFeignClients//不同点：@EnableEurekaClient只适用于
public class TestspringcloudProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringcloudProductApplication.class, args);
    }

}
