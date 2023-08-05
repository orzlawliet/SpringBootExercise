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
 * @create 2023-08-03 下午 05:17
 */
@Slf4j
@Service
public class SysService {
    @Order(3)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        log.info("======= SysService ====感知事件 =======" + loginSuccessEvent);
        UserEntity source = (UserEntity)loginSuccessEvent.getSource();
        recordLog(source.getUsername());
    }
    public void recordLog(String username){
        log.info(username + " 訊息已被紀錄");
    }
}
