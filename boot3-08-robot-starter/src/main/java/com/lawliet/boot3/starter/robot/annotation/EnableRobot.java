package com.lawliet.boot3.starter.robot.annotation;

import com.lawliet.boot3.starter.robot.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import java.lang.annotation.*;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-05 上午 06:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot {
}
