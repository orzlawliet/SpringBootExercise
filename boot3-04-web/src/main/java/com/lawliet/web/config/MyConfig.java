package com.lawliet.web.config;

import com.lawliet.web.component.MyYamlHttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Lawliet
 * @Description 靜態配置
 * @create 2023-07-23 上午 05:50
 */
//@EnableWebMvc //禁用boot的默認配置
@Configuration //這是一個配置類，給容器中放一個WebMvcConfigurer 組件
public class MyConfig /* implements WebMvcConfigurer */ {


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override //配置靜態資源
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                WebMvcConfigurer.super.addResourceHandlers(registry);
                registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/aa/","classpath:/bb/")
                .setCacheControl(CacheControl.maxAge(1190, TimeUnit.SECONDS));
            }

            @Override //配置攔截器
            public void addInterceptors(InterceptorRegistry registry) {
                WebMvcConfigurer.super.addInterceptors(registry);
            }

            @Override //配置一個能把對象轉為yaml的messageConverters
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
                WebMvcConfigurer.super.configureMessageConverters(converters);
                converters.add(new MyYamlHttpMessageConverters());
            }
        };
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //保留以前
////        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//        //自己寫
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/aa/","classpath:/bb/")
//                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//
//
//    }
}
