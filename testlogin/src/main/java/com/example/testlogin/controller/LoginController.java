package com.example.testlogin.controller;

import com.example.testlogin.pojo.SysUser;
import com.example.testlogin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String username, String password) {
        SysUser sysUser = sysUserService.doLogin(username, password);
        if (sysUser != null) {
            return "success";
        } else {
            return "error0";
        }
    }
}
