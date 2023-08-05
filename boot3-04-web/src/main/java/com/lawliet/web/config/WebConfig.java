package com.lawliet.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lawliet
 * @Description 全面接管MVC
 * @create 2023-07-29 下午 03:04
 */
//@EnableWebMvc //禁用mvc的默認功能
@Configuration
public class WebConfig implements WebMvcConfigurer {

}
