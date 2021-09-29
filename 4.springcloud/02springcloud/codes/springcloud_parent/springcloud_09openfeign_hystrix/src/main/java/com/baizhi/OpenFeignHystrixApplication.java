package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//开启服务注册客户端  consul server
@EnableFeignClients //开启OpenFeign调用
public class OpenFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignHystrixApplication.class,args);
    }
}
