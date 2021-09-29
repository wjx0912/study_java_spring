package com.baizhi;

import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootRedisApplication.class)
@RunWith(SpringRunner.class)
public class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testRedis(){
        //string opsForValue list opsForList set opsForSet() zset opsForZSet hash
        stringRedisTemplate.opsForValue().set("name","xiaohei");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);

    }


    @Test
    public void testRedisTemplate(){


        //设置key序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置hashkey序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        User user = new User();
        user.setId(1);
        user.setName("xiaoming");
        user.setAge(23);
        user.setSalary(2300.23);
        redisTemplate.opsForValue().set("user",user);
    }

}
