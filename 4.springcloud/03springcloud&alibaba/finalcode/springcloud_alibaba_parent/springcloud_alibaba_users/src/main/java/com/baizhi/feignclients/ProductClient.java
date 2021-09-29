package com.baizhi.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PRODUCTS")
public interface ProductClient {

    @GetMapping("/product")
    String product();
}
