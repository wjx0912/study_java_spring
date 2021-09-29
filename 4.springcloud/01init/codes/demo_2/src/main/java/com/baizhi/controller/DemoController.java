package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController //等价于  =   @Controller  +  @ResponseBody组合注解  作用: 将controller中所有方法返回值都转换为json进行响应
@RequestMapping("demo")
public class DemoController {


    @RequestMapping("demo")
    //@ResponseBody
    public Map<String,String> dmeo(){
        System.out.println("demo ok");
        Map<String, String> result = new HashMap<>();
        result.put("msg","demo ok");
        return result;
    }

    @RequestMapping("test")
    //@ResponseBody
    public String test(){
        System.out.println("test ok");
        return "test ok ";
    }
}
