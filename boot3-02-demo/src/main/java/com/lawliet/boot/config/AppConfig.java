package com.lawliet.boot.config;


import com.lawliet.boot.bean.Pig;
import com.lawliet.boot.bean.Sheep;
import com.lawliet.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

//@Import(FastsqlException.class) //給容器中放指定類型的組件，組件的名字默認是全類名
/*
 * 1.打開Sheep組件的屬性綁定
 * 2.默認會把這組件自己放到容器中
 *
 */
@EnableConfigurationProperties(Sheep.class) //導入第三方寫好的組件進行屬性綁定
@SpringBootConfiguration //這是一個配置文件 替代以前的配置文件，配置類本身也是容器中的組件
//@Configuration
public class AppConfig {
    @ConfigurationProperties(prefix = "pig")
    @Bean
    public Pig pig() {
        return new Pig();//我們自己new新pig
    }

    /*
     * 1.組件默認是單實例的
     * */
    @Scope("prototype")
    @Bean("userHaha") //替代以前的Bean標籤 組件在容器中的名字 可以直接修改註解的值
    public User user01() {
        var user = new User();
        user.setId(1L);
        user.setName("LKK");
        return user;
    }

//    @Bean
//    public FastsqlException fastsqlException() {
//        return new FastsqlException();
//    }
}
