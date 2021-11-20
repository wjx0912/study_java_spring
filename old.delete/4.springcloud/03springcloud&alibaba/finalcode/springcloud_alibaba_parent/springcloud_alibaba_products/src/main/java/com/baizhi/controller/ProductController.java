package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product(){
        log.info("product ok....");
        return  "product ok,当前服务端口号为: "+port;
    }
}
