package com.baizhi.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);


    //demo
    @GetMapping("/demo")  //blockHandler 使用sentinel进行不同规则控制时的默认处理方案   fallback:自定义业务出错时默认处理方案   defaultFallback 指定一个业务错误时默认方案
    @SentinelResource(value = "aaaa",blockHandler = "blockHandler",fallback = "fall",defaultFallback = "defaultFall")  //作用代表这是一个sentinel资源
    public String demo(Integer id) {
        log.info("demo ok ....");
        if (id < 0) throw new RuntimeException("id无效");
        return "demo ok !!!";

    }
    //
    public String blockHandler(Integer id, BlockException e){
        if(e instanceof FlowException){
            return  "当前请求过于火爆,您已被流控!!!";
        }
        if(e instanceof DegradeException){
            return  "当前请求过于火爆,您已被降级!!!";
        }
        if(e instanceof ParamFlowException){
            return  "当前请求过于火爆,您已被热点参数限流!!!";
        }
        return "服务器快爆了,请稍后再试!!!";
    }

    public String fall(Integer id){
        return "自定义服务器出错啦!!!";
    }

    public String defaultFall(){
        return "默认服务器出错啦!!!";
    }

    @GetMapping("/test")
    public String test(){
        log.info("test ok ....");
        return "test ok ";
    }
}
