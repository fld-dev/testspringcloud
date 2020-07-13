package com.db.test;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class TestApplication {

//    @Autowired
//    SysUserService sysUserService;
//
//    @Test
//    public void testMybatis(){
//        SysUser sysUser = sysUserService.doLogin("admin", "123456");
//        System.out.println("该用户的id为：");
//        System.out.println(sysUser.getId());
//    }

    public static void main(String[] args) {
        SpringApplication.run(test.TestApplication.class, args);
    }

}