package com.test.testspringcloudcousumer.controller;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.test.testspringcloudcousumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CousumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductService productService;

    @Bean
    @LoadBalanced//加载开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean//开启随机分配策略
    public IRule myRule(){
        return new RandomRule();//通过随机算法分配服务端
    }

    @RequestMapping("getCousumer")
    public String getCousumer(){
        String object = restTemplate.getForObject("http://product-server/getProduct", String.class);
        return object;
    }

}
