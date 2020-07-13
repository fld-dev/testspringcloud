package com.example.testlogin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    //@RequiresPermissions("user:list")
    @RequiresRoles("admin")
    @RequestMapping(value = "/testSuccess",method = RequestMethod.GET)
    public String testSuccess(){
        return "success";
    }

    @RequiresPermissions("user:error")
    @RequestMapping(value = "/testError1",method = RequestMethod.GET)
    public String testError1(){
    return "error1";
    }
}
