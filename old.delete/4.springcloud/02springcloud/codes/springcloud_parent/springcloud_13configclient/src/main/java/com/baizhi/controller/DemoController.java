package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //作用: RefreshScope 用来在不需要重启微服务情况下,将当前scope域中信息刷新为最新配置信息
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok!!!");
        return "demo ok: " +name;
    }
}
