package com.zwc.b.api.impl;

import com.zwc.b.api.feign.FeignMapper;
import org.springframework.stereotype.Component;

/*
 * @ClassName FeignApi
 * @Desc TODO   fallback
 * @Date 2019/5/20 23:21
 * @Version 1.0
 */
@Component
public class FeignMapperFallBack implements FeignMapper {

    /*
     * @ClassName FeignApiFallBack
     * @Desc TODO   调用 hystrix-c 服务中的 c() 方法失败时执行
     * @Date 2019/5/20 23:31
     * @Version 1.0
     */
    @Override
    public String c() {
        return "Hello！c服务调用异常,已熔断";
    }
}
