package com.lawliet.boot3.ssm.controller;

import com.lawliet.boot3.ssm.bean.TUser;
import com.lawliet.boot3.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-31 下午 10:08
 */

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    /**
     * 返回User的json數據
     * @param id
     * @return TUser
     * */
    @GetMapping("/user/{id}")
    public TUser getUser(@PathVariable Long id){
        TUser user = userMapper.getUserById(id);
        return user;
    }

    @GetMapping("/users/{id}")
    public String XXX(@PathVariable Long id){
        String XXx = "XXX:" + id ;
        return XXx;
    }
}
