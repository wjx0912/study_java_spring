package com.baizhi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired  //服务注册与发现客户端对象
    private DiscoveryClient discoveryClient;


    @Autowired //负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private  RestTemplate restTemplate;



    @GetMapping("user")
    public String invokeDemo(){
        log.info("user  demo....");

        //1.调用订单服务 服务地址url: http://localhost:9999/order   必须GET方式    接收返回值 String类型
        //RestTemplate restTemplate = new RestTemplate();
        //String orderResult = restTemplate.getForObject("http://"+randomHost()+"/order", String.class);


        //2.使用ribbon组件+RestTemplate实现负载均衡调用   1.DiscoveryClient   2.LoadBalanceClient    @LoadBalance
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("ORDERS");
//        serviceInstances.forEach(serviceInstance -> {
//            log.info("服务主机: {} 服务端口:{} 服务地址:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
//        });
//        String result = new RestTemplate().getForObject(serviceInstances.get(0).getUri() + "/order", String.class);


        //3.使用loadbalanceClient进行服务调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");//默认轮询
        //log.info("服务地址:{} 服务主机:{} 服务端口:{}",serviceInstance.getUri(),serviceInstance.getHost(),serviceInstance.getPort());
        //String result = restTemplate.getForObject(serviceInstance.getUri() + "/order", String.class);


        //4.使用@LoadBalanced注解 作用:可以让对象具有ribbon负载均衡特性
        String result = restTemplate.getForObject("http://ORDERS/order",String.class);

        //string自己  转为对象

        return  "ok"+result;
    }



    //自定义随机策略
    public String randomHost(){
        List<String> hosts = new ArrayList<>();
        hosts.add("localhost:9999");
        hosts.add("localhost:9990");
        //生成随机数 只能在0-hosts.size()
        int i = new Random().nextInt(hosts.size());
        return hosts.get(i);
    }




}
