package com.lawliet.boot3.ssm;

import com.lawliet.boot3.starter.robot.annotation.EnableRobot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 1. @MapperScan【批量掃描註解】； 告訴MyBatis，掃描哪個包下面的所有接口
 * 2、使用mybatis.mapper-locations，告訴MyBatis，每個接口的xml文件都在哪裡
 * 3、MyBatis自動關聯綁定。
 */

//@EnableRobot
@MapperScan(basePackages = "com.lawliet.boot3.ssm.mapper")
@SpringBootApplication
public class Boot305SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot305SsmApplication.class, args);
    }

}
