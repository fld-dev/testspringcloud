package com.test.testspringcloudproduct.controller;

import com.test.testspringcloudentity.entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping("getProduct")
    public String getProduct(){
        Product product = new Product();
        return product.toString();
    }
}
