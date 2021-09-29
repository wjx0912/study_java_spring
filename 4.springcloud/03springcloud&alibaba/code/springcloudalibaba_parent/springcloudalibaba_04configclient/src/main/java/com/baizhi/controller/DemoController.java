package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //允许远端配置修改自动刷新
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @Value("${customer.username}")
    private String username;


    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok !!!");
        return "demo ok !!! username:"+ username;
    }
}
