package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //这个注解可以省略不写
//@MapperScan("com.baizhi.dao")//  @MapperScanner: 一次性扫描创建所有DAO对象  @mapper: 创建指定DAO对象
public class CityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);
    }
}
