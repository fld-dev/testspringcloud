package com.example.testlogin;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@SpringBootApplication
@MapperScan("com.example.testlogin.dao")
public class TestloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestloginApplication.class, args);
    }

}
