package com.lawliet.boot.core.service;

import com.lawliet.boot.core.entity.UserEntity;
import com.lawliet.boot.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 06:30
 */
@Slf4j
@Service
public class HahaService {

    @Order(4)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        log.info("======= HahaService ====感知事件 =======" + loginSuccessEvent);
        //調用業務

    }

}
