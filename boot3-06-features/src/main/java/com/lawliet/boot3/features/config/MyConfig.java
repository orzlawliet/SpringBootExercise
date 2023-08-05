package com.lawliet.boot3.features.config;

import com.lawliet.boot3.features.bean.Cat;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-01 下午 11:40
 */
//@PropertySource("classpath:aaa.properties")
@Profile("test")  //只有指定環境被激活整個類的所有配置才能生效
@Configuration
public class MyConfig {

    @Profile("dev")
    @Bean
    public Cat cat(){
        return new Cat();
    }
}
