package com.test.testspringcloudcousumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

//name为product项目中yml中的application的name,path为product项目中yml的server的context-path
@FeignClient(name = "product-server",path = "/product")
@Component//可以不用加 idea不报错，但会显示警告
public interface ProductService {
    @RequestMapping("getProduct")
    String getProduct();
}
