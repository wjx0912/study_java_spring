package com.baizhi.feignclients;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// 自定义HystrixClient 默认备选处理
@Configuration
public class HystrixClientFallBack implements HystrixClient {


    @Override
    public String demo(Integer id) {
        return "当前服务不可用,请稍后再试! id: "+id;
    }
}
