package com.test.testspringclooudproduct8088.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @RequestMapping("getProduct")
    public String getProduct(){
        return "hello,springCloud"+"我是8088端口";
    }
}
