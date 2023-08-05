package com.lawliet.boot;

import com.lawliet.boot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//主程序：com.lawliet.boot
//com.lawliet.boot.controller.HelloController
//@SpringBootApplication(scanBasePackages = "com.lawliet")
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.lawliet")
@SpringBootApplication //SpringBoot應用
public class MainApplication {
    //主程序
    public static void main(String[] args){
        //java10： 局部變量類型的自動推斷
        var ioc = SpringApplication.run(MainApplication.class, args);

        //1、獲取容器中所有組件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2、挨個遍歷：
        // dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        // SpringBoot把以前配置的核心组件现在都给我们自動配置好了。
//        for (String name : names) {
//            System.out.println("name：" + name);
//        }
        Person person = ioc.getBean(Person.class);
        System.out.println("person：" + person);
        System.out.println("*******用|表示文版,會保留格式");
        String s1 =person.getChild().getText().get(2);
        System.out.println(s1);
        System.out.println("*******用>表示大文本，會壓縮換行變成 空格");
        String s2 =person.getChild().getText().get(3);
        System.out.println(s2);
        System.out.println("*******用|表示大文本，會壓縮換行變成 空格");
        String s3 =person.getChild().getText().get(4);
        System.out.println(s3);
    }
}
