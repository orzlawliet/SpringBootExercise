package com.lawliet.boot3.starter.robot.controller;


import com.lawliet.boot3.starter.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-04 下午 11:08
 */

@RestController
public class RobotConrtoller {

    @Autowired
    RobotService robotService;

    @GetMapping("/robot/hello")
    public String sayHello(){
        String s =robotService.sayHello();
        return s;
    }
}
