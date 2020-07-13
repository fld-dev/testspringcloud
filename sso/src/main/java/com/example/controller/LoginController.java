package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/loginHtml")
    public String returnLogin(){
        return "Login";
    }
    @RequestMapping("/indexHtml")
    public String returnIndex(){
        return "Index";
    }
    @PostMapping("login")
    public String login(HttpServletRequest req, HttpServletResponse res, User user, Model model){
        try{
            User u=userService.userLogin(req,res,user);
            if(u==null){
                model.addAttribute("error","用户名或密码不匹配");
                return "Login.html";
            }
            return "redirect:Index.html";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("error","用户名或密码不匹配");
            return "Login.html";
        }
    }
    @GetMapping("info")
    @ResponseBody
    public Map getUserInfo(HttpServletRequest req, HttpServletResponse res){
        Map<Object,Object>map=new HashMap<>();
        try {
            User us=userService.getUserByToken(res,req);
            if(us!=null){
                map.put("success",true);
            }else {
                map.put("success",false);
            }
            return map;
        } catch (Exception e) {
            map.put("success","根据token获取用户信息失败");
            return map;
        }
    }
}
