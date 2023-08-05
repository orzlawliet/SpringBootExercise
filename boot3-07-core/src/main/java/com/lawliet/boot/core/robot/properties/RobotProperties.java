package com.lawliet.boot.core.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-04 下午 11:01
 */

@ConfigurationProperties(prefix = "robot") //此屬性類和配置文件指定前綴綁定
@Component
@Data
public class RobotProperties {

    private String name;
    private String age;
    private String email;

}
