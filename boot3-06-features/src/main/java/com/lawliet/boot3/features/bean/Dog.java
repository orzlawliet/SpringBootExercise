package com.lawliet.boot3.features.bean;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@Profile({"test"})
@Component
public class Dog {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
