package com.lawliet.boot.core.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 03:56
 */
@Slf4j
public class MyListener  implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("=====事件=====到達======" +event);
    }
}
