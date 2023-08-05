package com.lawliet.boot.core.service;

import com.lawliet.boot.core.entity.UserEntity;
import com.lawliet.boot.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 05:17
 */
@Slf4j
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {

    public void addAccountScore(String username){
        log.info(username + " 加了1分");
    }
    @Order(2)
    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        log.info("======= AccountService 收到事件 =======");
         UserEntity source = (UserEntity)event.getSource();
        addAccountScore(source.getUsername());
    }
}
