package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Product;
import com.baizhi.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanIterator;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    private ProductClient productClient;



    @GetMapping("/list")
    public String list(){
        return "list ok";
    }

    @GetMapping("/category")
    public String category(){
        log.info("category service ....");
        //1.RestTemplate 2.RestTemplate+Ribbon() 3.OpenFeign
        //String result = productClient.test("小陈", 23);
        //String result = productClient.test1(21,"xiaoming");
        String result = productClient.test2(new Product(1, "超短裙", 23.23, new Date()));
        //String result = productClient.test3(new String[]{"21","23","24"});
        //String result = productClient.test4(new String[]{"21","23","24"});
        //Product product = productClient.product(21);
        //log.info("product: {}",product);
        //List<Product> products = productClient.findByCategoryId(1);
        //products.forEach(product -> log.info("product: {}",product));
        /*String result = productClient.findByCategoryIdAndPage(1, 5, 1);
        System.out.println(result);

        //自定义json反序列化   对象转为json 序列化   on字符串转为对象

        JSONObject jsonObject = JSONObject.parseObject(result);
        System.out.println(jsonObject.get("total"));
        Object rows = jsonObject.get("rows");
        System.out.println(rows);

        //二次json反序列化
        List<Product> products = jsonObject.parseArray(rows.toString(), Product.class);
        products.forEach(product -> {
            log.info("product:{}",product);
        });*/

        //String result = productClient.product();

        return result;
    }
}
