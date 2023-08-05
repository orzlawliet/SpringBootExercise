package com.lawliet.boot.config;

import com.lawliet.boot.bean.Cat;
import com.lawliet.boot.bean.Dog;
import com.lawliet.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
@ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")  //放在類級別，如果註解判斷生效，則整個配置類才生效。
//SpringBoot默認只掃描自己主程序所在的包。如果導入第三方包，即使組件上標註了 @Component、@ConfigurationProperties 註解，也沒用。因為組件都掃描不進來
@SpringBootConfiguration
public class AppConfig2 {

//    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")  //放在方法級別，單獨對這個方法進行註解判斷。
    @Bean
    public Cat cat01() {
        return new Cat();
    }

//    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01() {
        return new Dog();
    }

    @ConditionalOnBean(value = Dog.class)
    @Bean
    public User Chansan() {
        return new User();
    }

    @ConditionalOnMissingBean(value = Dog.class)
    @Bean
    public User Leesi() {
        return new User();
    }
}
