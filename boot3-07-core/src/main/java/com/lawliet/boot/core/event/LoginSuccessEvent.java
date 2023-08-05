package com.lawliet.boot.core.event;

import com.lawliet.boot.core.entity.UserEntity;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author Lawliet
 * @Description 登錄成功事件。所有事件都推薦繼承 ApplicationEvent
 * @create 2023-08-03 下午 05:59
 */
public class LoginSuccessEvent extends ApplicationEvent {


    /**
     *
     * @param source  代表是誰登錄成了
     */
    public LoginSuccessEvent(UserEntity source){
        super(source);
    }
}
