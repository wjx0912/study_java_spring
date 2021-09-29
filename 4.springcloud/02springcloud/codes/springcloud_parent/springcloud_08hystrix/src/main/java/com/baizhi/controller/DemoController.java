package com.baizhi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {



    @GetMapping("/demo1")
    @HystrixCommand(defaultFallback = "defaultFallBack")
    public String demo1(){
        System.out.println("demo1 ok!!");
        return "demo1 ok !!!";
    }

    @GetMapping("demo")
    @HystrixCommand(defaultFallback = "defaultFallBack")//熔断之后处理 fallbackMethod 书写快速失败方法名
    public String demo(Integer id){
        System.out.println("demo ok !!!");
        if(id<=0){
            throw new RuntimeException("无效id!!!!");
        }
        return "demo ok !!!";
    }

    //默认的处理方法
    public String defaultFallBack(){
        return "网络连接失败,请重试!!!";
    }

    //自己备选处理
    public String demoFallBack(Integer id){
        return "当前活动过于火爆,服务已经被熔断了!!!";
    }
}
