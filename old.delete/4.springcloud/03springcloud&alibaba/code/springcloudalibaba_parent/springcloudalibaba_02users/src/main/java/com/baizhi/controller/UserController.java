package com.baizhi.controller;

import com.baizhi.feignclients.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private DiscoveryClient discoveryClient;//服务发现客户端

    @Autowired
    private LoadBalancerClient loadBalancerClient; //负载均衡客户端组件

    @Autowired
    private RestTemplate restTemplate;  //这个对象才是具有负载均衡restTemplate


    @Autowired
    private ProductClient productClient;

    //推荐http rest方式通信: 1.restTemplate
    @GetMapping("/invoke")
    public String invokeProduct(){
        log.info("调用用户服务....");
        //调用商品服务 缺点: 1.无法实现请求负载均衡  2.路径写死代码中不利于后续维护
        //String result = new RestTemplate().getForObject("http://localhost:9090/product?id=21", String.class);

        //1.discoveryClient使用ribbon组件实现负载均衡 1.引入ribbon依赖(nacos client 存在这个依赖) 2.使用ribbon完成负载均衡  DiscoveryClient  LoadBalanceClient  @LoadBalance
        //List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PRODUCTS");
        //for (ServiceInstance serviceInstance : serviceInstances) {
        //    log.info("服务主机:{} 服务端口:{} 服务uri:{}",serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        //}
        //2.loadbalanceClient
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTS"); //已经进行负载均衡之后返回节点 轮询
        //String result =new RestTemplate().getForObject(serviceInstance.getUri()+"/product?id=21",String.class);

        //3.@LoadBalance注解
        //String result = this.restTemplate.getForObject("http://PRODUCTS/product?id=21", String.class);
        String result = productClient.product(21);
        log.info("商品服务调用结果: {}",result);
        return  result;
    }
}
