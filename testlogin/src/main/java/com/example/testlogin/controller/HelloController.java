package com.example.testlogin.controller;

import com.example.testlogin.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/import")
    public String import1(){
        return "import";
    }

    @RequestMapping("/error1")
    public String error1(){
        return "error1";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/testLogin",method = RequestMethod.POST)

    public String testLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        Subject subject = SecurityUtils.getSubject();
        //根据用户名和用户密码创建token.
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);

            //执行登录操作
            try {
                subject.login(token);//此值会交给安全管理器对象 安全管理器会完成认证操作
                //return new JsonResult("登录成功");
                return "hello";
                //return "登录成功";
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("用户名或密码错误");
                return "login";
            }



    }

    @RequestMapping("/testShiro")
    public String testShiro(){
        return "import";
    }
}
