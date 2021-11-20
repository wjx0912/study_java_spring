package com.baizhi.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PRODUCTS")
public interface ProductClient {

    @GetMapping("/product")
    String product(@RequestParam("id") Integer id);
}
