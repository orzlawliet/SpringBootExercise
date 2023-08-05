package com.lawliet.logging.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lawliet
 * @Description 測試線程
 * @create <time>
 */
@Slf4j
@RestController
public class controller {
//    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/h")
    public String hello(String a,String b){
        log.info("哈哈哈，Slf4j進來了！");
//        logger.info("哈哈哈，進來了！");
        for(int i = 1 ;i < 1000;i++){
            log.info("info 日誌...參數a:{} b:{}",a+b,b);
            log.warn("warn 日誌...參數a:{} b:{}",a,b);
            log.error("error 日誌");
        }
        log.trace("trace 日誌");
        log.debug("trace 日誌");
        //SpringBoot底層默認的日誌級別是INFO
        log.info("info 日誌...參數a:{} b:{}",a+b,b);
        log.warn("warn 日誌...參數a:{} b:{}",a,b);
        log.error("error 日誌");


        return "Hello";
    }
}
