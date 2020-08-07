package com.test.testspringclooudproduct8088;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//这两个注解都是让eureka发现服务，并将服务注册到eureka上的注解
@EnableEurekaClient//相同点：都能让注册中心eureka发现，并将服务注册到eureka
@EnableFeignClients//不同点：@EnableFeignClients表示开启Feign客户端
public class TestspringclooudProduct8088Application {

    public static void main(String[] args) {
        SpringApplication.run(TestspringclooudProduct8088Application.class, args);
    }

}
