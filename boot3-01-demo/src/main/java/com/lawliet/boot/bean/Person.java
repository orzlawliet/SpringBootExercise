package com.lawliet.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person") //和配置文件person前缀的所有配置进行绑定
@Data //自動生成JavaBean屬性的getter/setter
//@NoArgsConstructor //自動生成無參構造器
//@AllArgsConstructor //自動生成全參構造器
public class Person {
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    private Child child; //嵌套對象
    private List<Dog> dogs; //數組（裡面是對象）
    private Map<String,Cat> cats; //表示Map
}
