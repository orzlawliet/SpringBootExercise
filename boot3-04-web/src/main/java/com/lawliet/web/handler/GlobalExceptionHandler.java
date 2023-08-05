package com.lawliet.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-29 上午 10:48
 */
@ControllerAdvice //這是類是集中處理所有 @Controller 發生的錯誤
public class GlobalExceptionHandler {

    /**
     * 1.@ExceptionHandler 標識一個方法處理錯誤，默認只能處理這個類發生的指定錯誤。
     * 2.@ControllerAdvice 統一處理所有錯誤
     * @return e
     */
    @ResponseBody //對象寫出為json
    @ExceptionHandler(Exception.class)
    public  String handleExcepion(Exception e){

        return "Oh~No~統一處理，原因是：" + e.getMessage();
    }

}
