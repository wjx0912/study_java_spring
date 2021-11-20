package com.baizhi.feign;


import com.baizhi.entity.Clazz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLAZZS")
public interface ClazzClient {

    //班级信息
    @GetMapping("/clazzs/{id}")
    Clazz clazz(@PathVariable Integer id);
}
