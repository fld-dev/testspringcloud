package com.test.testspringcloudcousumer.controller;

import com.test.testspringcloudcousumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CousumerController {

    @Autowired
    ProductService productService;

    @RequestMapping("getCousumer")
    public String getCousumer(){
        String str = productService.getProduct();
        return str;
    }

}
