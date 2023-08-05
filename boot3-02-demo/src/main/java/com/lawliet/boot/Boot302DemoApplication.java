package com.lawliet.boot;


import com.lawliet.boot.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        //主程序
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
//        for (String name : ioc.getBeanDefinitionNames()) {
//            System.out.println("name：" + name);
//        }
//        String[] forTypes = ioc.getBeanNamesForType(FastsqlException.class);
//        for(String forType:forTypes){
//            System.out.println("forType：" + forType);
//        }
//        Object userHaha1 = ioc.getBean("userHaha");
//        Object userHaha2 = ioc.getBean("userHaha");
//        System.out.println(userHaha2 == userHaha1);
        for (String s : ioc.getBeanNamesForType(Cat.class)) {
            System.out.println("Cat：" + s);
        }

        for (String s : ioc.getBeanNamesForType(Dog.class)) {
            System.out.println("Dog：" + s);
        }

        for (String s : ioc.getBeanNamesForType(User.class)) {
            System.out.println("User：" + s);
        }

        Pig pig = ioc.getBean(Pig.class);
        System.out.println("Pig：" + pig);

        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println("Sheep：" + sheep);
    }

}
