package com.baizhi.controller;

import com.baizhi.feignclients.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/invoke")
    public String invokeProduct(){
        log.info("user invoke ok...");
        //String result = restTemplate.getForObject("http://PRODUCTS/product", String.class);
        String result = productClient.product();
        log.info("result:{}",result);
        return  result;
    }
}
