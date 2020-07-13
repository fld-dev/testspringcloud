package com.db.controller;

import test.entity.SysUser;
import test.servic.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,Integer password){
        SysUser sysUser = sysUserService.doLogin(name, password);
        if (null != sysUser){
            return "success";
        }else{
            return "error0";
        }
    }
}