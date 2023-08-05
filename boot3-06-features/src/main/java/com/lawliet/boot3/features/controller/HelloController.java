package com.lawliet.boot3.features.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 上午 12:52
 */
@RestController
public class HelloController {

//    @Value("${haha}")
//    String hahaS;
//
    @Value("${haha:aoaoao}")
    String haha;


    @GetMapping("/haha")
    public String haha(){
        return haha;
    }
}
