package com.lawliet.boot.core.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;
import java.util.Spliterator;

/**
 * @author Lawliet
 * @Description
 * @create 2023-08-03 下午 02:32
 */

/**
 * Listener 先要從 META-INF/spring.factories 讀到
 *
 * 1、引導： 利用 BootstrapContext 引導整個項目啟動
 *      starting：              應用開始，SpringApplication的run方法一調用，只要有了 BootstrapContext 就執行
 *      environmentPrepared：   環境準備好（把啟動參數等綁定到環境變量中），但是ioc還沒有創建；【調一次】
 * 2、啟動：
 *      contextPrepared：       ioc容器創建並準備好，但是sources（主配置類）沒加載。並關閉引導上下文；組件都沒創建  【調一次】
 *      contextLoaded：         ioc容器加載。主配置類加載進去了。但是ioc容器還沒刷新（我們的bean沒創建）。
 *      =======截止以前，ioc容器裡面還沒造bean呢=======
 *      started：               ioc容器刷新了（所有bean造好了），但是 runner 沒調用。
 *      ready:                  ioc容器刷新了（所有bean造好了），所有runner調用完了。
 * 3、運行
 *     以前步驟都正確執行，代表容器running。
 */
@Slf4j
public class MyAppListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        SpringApplicationRunListener.super.starting(bootstrapContext);
        log.info("=====starting=====正在啟動======");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
        log.info("=====starting=====環境準備完成======");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextPrepared(context);
        log.info("=====starting=====ioc容器準備完成======");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextLoaded(context);
        log.info("=====starting=====ioc容器加載完成======");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        SpringApplicationRunListener.super.started(context, timeTaken);
        log.info("=====starting=====啟動完成======");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        SpringApplicationRunListener.super.ready(context, timeTaken);
        log.info("=====starting=====準備就緒======");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        SpringApplicationRunListener.super.failed(context, exception);
        log.info("=====starting=====應用啟動失敗======");
    }
}
