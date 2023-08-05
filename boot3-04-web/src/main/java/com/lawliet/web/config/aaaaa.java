package com.lawliet.web.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-29 下午 03:39
 */
@Component("Aaaaa")
public class aaaaa implements View {

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("aaaaa");
    }
}
