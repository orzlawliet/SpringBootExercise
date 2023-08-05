package com.lawliet.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/haha")
    public String hello(){
        return "Hello";
    }
}
