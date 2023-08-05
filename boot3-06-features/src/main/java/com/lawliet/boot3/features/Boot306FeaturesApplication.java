package com.lawliet.boot3.features;

import com.lawliet.boot3.features.bean.Cat;
import com.lawliet.boot3.features.bean.Dog;
import com.lawliet.boot3.features.bean.Pig;
import com.lawliet.boot3.features.bean.Sheep;
import com.lawliet.boot3.starter.robot.RobotAutoConfiguration;
import com.lawliet.boot3.starter.robot.annotation.EnableRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
/**
 * 環境隔離：
 * 1、標識環境
 *    1）、區分出幾個環境： dev（開發環境）、test（測試環境）、prod（生產環境）
 *    2）、指定每個組件在哪個環境下生效； default環境：默認環境
 *          通過： @Profile({"test"})標註
 *          組件沒有標註@Profile代表任意時候都生效
 *    3）、默認只有激活指定的環境，這些組件才會生效。
 * 2、激活環境
 *    配置文件激活：spring.profiles.active=dev；
 *    命令行激活： java -jar xxx.jar  --spring.profiles.active=dev
 *
 * 3、配置文件怎麼使用Profile功能
 *    1）、application-test.properties： 主配置文件。任何情況下都生效
 *    2）、其他Profile環境下命名規範：  application-{profile標識}.properties：
 *          比如：application-dev.properties
 *    3）、激活指定環境即可：  配置文件激活、命令行激活
 *    4）、效果：
 *        項目的所有生效配置項 = 激活環境配置文件的所有項 + 主配置文件和激活文件不衝突的所有項
 *        如果發生了配置衝突，以激活的環境配置文件為準。
 *        application-{profile標識}.properties 優先級高於 application-test.properties
 *
 *        主配置和激活的配置都生效，優先以激活的配置為準
 */

//SpringBoot的默認掃描規則，只掃描自己主程序所在的包以及子包

/**
 * 自定義starter所有組件包名：com.atguigu.boot3.starter.robot
 * 當前項目的主程序所在包：    com.atguigu.boot3.features
 */
@EnableRobot
@Slf4j
//@Import(RobotAutoConfiguration.class)
@SpringBootApplication //主程序類
public class Boot306FeaturesApplication {

    public static void main(String[] args) {
        //1、SpringApplication: Boot應用的核心API入口
//        SpringApplication.run(Boot306FeaturesApplication.class, args);

        //1. 自定義SpringApplication的底層設置
//        SpringApplication application= new SpringApplication(Boot306FeaturesApplication.class);
//
//        //調整SpringApplication的參數
////        application.setDefaultProperties();
//        //這配置不優先
//        application.setBannerMode(Banner.Mode.OFF);
//
//        //【配置文件優先級高於程序化調整的優先級】
//
//        //2. SoringApplication 運行起來
//        application.run(args);

        //================2、Builder方式構建 SpringApplication； 通過FluentAPI進行設置
         ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .main(Boot306FeaturesApplication.class)
                .sources(Boot306FeaturesApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                 .properties("server.port=8888","aaa=bbb") //springboot所有配置項都可以在這裡定義
//                .environment(null)
//                .listeners(null)
                .run(args);
         try {
             Cat cat = context.getBean(Cat.class);
             log.info("cat： {}" , cat);
         }catch (Exception e){

         }

        try {
            Dog dog = context.getBean(Dog.class);
            log.info("dog： {}" , dog);
        }catch (Exception e){

        }

        try {
            Pig pig = context.getBean(Pig.class);
            log.info("pig： {}" , pig);
        }catch (Exception e){

        }

        try {
            Sheep sheep = context.getBean(Sheep.class);
            log.info("sheep： {}" , sheep);
        }catch (Exception e){

        }



    }


}
