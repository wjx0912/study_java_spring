package com.baizhi.feign;

import com.baizhi.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CITIES")
public interface CityClient {
    //城市信息
    @GetMapping("/cities/{id}")
    City city(@PathVariable("id") Integer id);

}
