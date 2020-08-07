package com.test.testsprinngcloudprovide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//表示这是一个注册中心
public class TestsprinngcloudprovideApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestsprinngcloudprovideApplication.class, args);
    }

}
