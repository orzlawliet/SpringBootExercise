package com.lawliet.web.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-29 下午 03:50
 */
@Service
public class AService {
    public void a (){
        //當前請求路徑
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        //任意位置隨時透過 RequestContextHolder 獲取到當前請求和響應訊息
        HttpServletResponse response = requestAttributes.getResponse();
        HttpServletRequest request = requestAttributes.getRequest();

        String requestURI=request.getRequestURI();
    }
}
