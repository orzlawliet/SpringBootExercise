package com.lawliet.boot.core.service;

import com.lawliet.boot.core.entity.UserEntity;
import com.lawliet.boot.core.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
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
public class CouponService {

    @Order(1)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent){
        log.info("======= CouponService ====感知事件 =======" + loginSuccessEvent);
        UserEntity source = (UserEntity)loginSuccessEvent.getSource();
        sendCoupon(source.getUsername());
    }
    public void sendCoupon(String username){
        log.info(username + " 隨機得到優惠券");
    }
}
