package com.lawliet.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
public class HelloController2 {

    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("/hello2")
    public String hello(){
        return "Hello,Spring Boot 3!";
    }

    @GetMapping("/incr2")
    public  String incr(){
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "增加值後：" + haha;
//        return "Hello,Spring Boot 2!";
    }

    @GetMapping("/redis/add")
    public String addRedis() {
        redisTemplate.opsForValue().set("liongogoRedisTest", "I am Lion GoGo");
        return "加入成功";
    }

    @GetMapping("/redis/get")
    public Object getRedis() {
        Object value = redisTemplate.opsForValue().get("liongogoRedisTest");
        return value;
    }
}
