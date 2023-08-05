package com.lawliet.boot3.starter.robot.service;

import com.lawliet.boot3.starter.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-04 下午 10:58
 */

@Service
public class RobotService {

    @Autowired
    RobotProperties robotProperties;
    public String sayHello(){
        return "你好： 名字【" + robotProperties.getName() +"】"
               + "，今年【" + robotProperties.getAge() + "】歲 "
                + "，電子信箱【" + robotProperties.getEmail() + "】 " ;
    }
}
