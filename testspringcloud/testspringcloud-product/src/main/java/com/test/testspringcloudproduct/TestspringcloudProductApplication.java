package com.test.testspringcloudproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication

//这两个注解都是让eureka发现服务，并将服务注册到eureka上的注解
@EnableEurekaClient//相同点：都能让注册中心eureka发现，并将服务注册到eureka
@EnableFeignClients//不同点：@EnableFeignClients表示开启Feign客户端
@MapperScan(basePackages = {"com.test.testspringcloudproduct.mapper"})

public class TestspringcloudProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringcloudProductApplication.class, args);
    }

}
