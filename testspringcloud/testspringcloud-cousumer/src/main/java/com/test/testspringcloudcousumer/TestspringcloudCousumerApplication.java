package com.test.testspringcloudcousumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

@EnableEurekaClient
@EnableFeignClients//开启Feign客户端
@EnableCircuitBreaker//添加熔断降级注解
public class TestspringcloudCousumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestspringcloudCousumerApplication.class, args);
    }

}
