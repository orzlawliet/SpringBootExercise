package com.lawliet.boot3.starter.robot;

import com.lawliet.boot3.starter.robot.controller.RobotConrtoller;
import com.lawliet.boot3.starter.robot.properties.RobotProperties;
import com.lawliet.boot3.starter.robot.service.RobotService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-04 下午 11:45
 */
//給容器中導入Robot功能要用的所有組件
//@Import({RobotConrtoller.class, RobotProperties.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration {

    @Bean //把組件導入容器中
    public RobotConrtoller robotConrtoller(){
        return new RobotConrtoller();
    }

}
