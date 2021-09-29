package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //省略
public class ProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class,args);
    }
}
