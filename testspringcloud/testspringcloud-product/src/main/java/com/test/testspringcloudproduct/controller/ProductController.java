package com.test.testspringcloudproduct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {
    @RequestMapping("getProduct")
    public String getProduct(){
        return "hello springCloud"+"我是8083端口";
    }

    @RequestMapping("/timeout")
    public String timeout() throws InterruptedException{
        log.info("调用端口超时");
        Thread.sleep(10000L);
        return "invoking timeout endpoint,port:8083";
    }

    @RequestMapping("/exception")
    public String exception(){
        log.info("调用端口异常");
        if (System.currentTimeMillis()%2==0){
            throw new RuntimeException("随机异常");
        }
        return "invoking exception endpoint,port:8083";
    }

    @RequestMapping("/getMsgFallback")
    public String getMsgFallback(){
        return "8083端口，运行中。。。";
    }


}
