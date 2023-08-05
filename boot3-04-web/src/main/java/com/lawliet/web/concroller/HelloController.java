package com.lawliet.web.concroller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.lawliet.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-23 上午 08:26
 */
@Slf4j
@RestController
public class HelloController {
    /*
     * 默認使用新版的PathPatternParser進行路徑匹配
     * 不能匹配 ** 在中間的情況，剩下的和AntPathMatcher　語法兼容
     * @param request
     * @param path
     * @return
    */
    @GetMapping("/a*/b?/{p1:[a-g]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path){

        log.info("路徑變量p1 : {}",path);
        String uri = request.getRequestURI();
        return uri;
    }

    /**
     * 1、默認支持把對象寫為json。因為默認web場景導入了jackson處理json的包;jackson-core
     * 2、jackson也支持把數據寫為xml。導入xml相關依賴
     * @return
     */
    @GetMapping("/person")
    public Person person(/*@RequestBody Person person*/){
        Person person = new Person();
        person.setId(1L);
        person.setUserName("張三");
        person.setEmail("aaa@qq.com");
        person.setAge(18);
//        int XX = 1*0/10/0;
        return person;
    }

    @Autowired //國際化取用的組件
    MessageSource messageSource;
    @GetMapping("/haha")
    public String haha(HttpServletRequest request){
        Locale locale = request.getLocale();
        String login = messageSource.getMessage("login",null,locale);
        return login;
    }

    public static void main(String[] ars ) throws JsonProcessingException {
        Person person = new Person();
        person.setId(1L);
        person.setUserName("張三");
        person.setEmail("aaa@qq.com");
        person.setAge(18);

        YAMLFactory fctory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(fctory);

        String s = mapper.writeValueAsString(person);
        System.out.println(s);
    }

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public  String handleExcepion(Exception e){
//
//        return "Oh~No~HelloController發生錯誤，原因是：" + e.getMessage();
//    }
}
