package com.test.testspringcloudcousumer.mapper;

import com.test.testspringcloudcousumer.impl.FallBackApiImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "product-server-8083",fallback = FallBackApiImpl.class)//或者fallbackFactory=FallBackFactoryImpl.class
public interface FallBackApi {//当有多个方法需要熔断降级处理时把这些方法同一写在这通过fallbackFactory=FallBackFactoryImpl.class同一处理

    @RequestMapping("/getMsgFallback")
    String  getMsgFallback();
}
