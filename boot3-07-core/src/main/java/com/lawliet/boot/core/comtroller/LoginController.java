package com.lawliet.boot.core.comtroller;

import com.lawliet.boot.core.entity.UserEntity;
import com.lawliet.boot.core.event.EventPublisher;
import com.lawliet.boot.core.event.LoginSuccessEvent;
import com.lawliet.boot.core.service.AccountService;
import com.lawliet.boot.core.service.CouponService;
import com.lawliet.boot.core.service.SysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lawliet
 * @Description 練習廣播
 * @create 2023-08-03 下午 05:12
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    AccountService accountService;

    @Autowired
    CouponService couponService;

    @Autowired
    SysService sysService;

    @Autowired
    EventPublisher eventPublisher;

    @GetMapping("/login")
    public String login (@RequestParam("username") String username,
                         @RequestParam("passwd") String passwd){

        //TODO 發送事件
        //1.創建自動訊息
        LoginSuccessEvent event = new LoginSuccessEvent(new UserEntity(username,passwd));
        eventPublisher.sendEvent(event);

        //業務處理登入
        log.info("業務處理中.....");
        //1.帳戶服務自動簽到加積分
//        accountService.addAccountScore(username);
//        //2.優惠服務隨機發放優惠券
//        couponService.sendCoupon(username);
//        //3.系統服務登記用戶登錄的信息
//        sysService.recordLog(username);

        //設計模式：對新增開放，對修改關閉
        //xxx
        //xxx
        return username + "登錄成功";

    }
}
