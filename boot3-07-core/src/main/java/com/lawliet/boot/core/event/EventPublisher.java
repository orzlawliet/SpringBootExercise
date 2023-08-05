package com.lawliet.boot.core.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 05:52
 */
@Service
@Slf4j
public class EventPublisher  implements ApplicationEventPublisherAware {
    /**
     * 底層發送事件用的組件，SpringBoot會通過ApplicationEventPublisherAware接口自動注入給我們
     * 事件是廣播出去的。所有監聽這個事件的監聽器都可以收到
     */
    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 所有事件都可以發
     * @param event
     */
    public void sendEvent(ApplicationEvent event) {
        //調用底層API發送事件
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 會被自動調用，把真正發事件的底層組組件給我們注入進來
     * @param applicationEventPublisher event publisher to be used by this object
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
