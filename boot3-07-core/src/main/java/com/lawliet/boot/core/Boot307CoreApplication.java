package com.lawliet.boot.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationTemp;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc //全面接管SpringMVC，禁用所有底層的自動配置
//@EnableAsync //開啟異步
//@EnableScheduling //開啟動時任務
@Slf4j
@SpringBootApplication //SPI
public class Boot307CoreApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Boot307CoreApplication.class);
        //參數設置
        application.addInitializers();

        application.run(args);
//        SpringApplication.run(Boot307CoreApplication.class, args);

    }

    @Bean
    public ApplicationRunner applicationRunner(){

        return  args -> {
            log.info("===ApplicationRunner 運行了.....");
        };
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(){
//        return  args -> {
//            log.info("===CommandLineRunner 運行了.....");
//        };
//    }
}
