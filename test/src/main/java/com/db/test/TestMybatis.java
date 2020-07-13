package com.db.test;

import test.entity.SysUser;
import test.servic.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestMybatis {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void test(){
        SysUser sysUser = sysUserService.doLogin("admin", 123456);
        System.out.println("======================");
        System.out.println(sysUser.getId());
    }
}
