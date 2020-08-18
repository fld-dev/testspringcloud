package com.test.testspringcloudcousumer.controller;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.test.testspringcloudcousumer.mapper.FallBackApi;
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

    @Autowired
    FallBackApi fallBackApi;

    @Bean
    @LoadBalanced//加载开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * RoundRobinRule(),默认的负载均衡策略，获取服务清单的下标，下标每次递增一访问，连续10次没有访问到服务则报警告
     * RandomRule()，通过随机算法分配服务端
     * @return
     */

    @Bean//重新创建一个负载均衡策略，表示不使用默认的负载均衡。
    public IRule myRule(){
        return new RandomRule();
    }

    @RequestMapping("getCousumer")
    public String getCousumer(){
        String object = restTemplate.getForObject("http://product-server/getProduct", String.class);
        return object;
    }

    @RequestMapping("testHystrix")
    public String testHystrix(){
        return fallBackApi.getMsgFallback();
    }

}
