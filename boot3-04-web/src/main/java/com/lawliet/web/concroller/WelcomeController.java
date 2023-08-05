package com.lawliet.web.concroller;

import com.lawliet.web.Service.AService;
import com.lawliet.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lawliet
 * @Description
 * @create 2023-07-23 下午 11:06
 */
@Controller //適配 服務端渲染 前後不分離模式開始
public class WelcomeController {

    @Autowired
    AService aService;
    //模板的邏輯視圖名
    //物理視圖 =  前綴 + 邏輯視圖名 + 後綴
    //真實地址 = classpath:/templates/welcome.html
    @GetMapping("/well")
    public String hello(@RequestParam("name") String name, Model model, HttpServletRequest request){

        //把需要給頁面共享的數據放到model中
//        String text = "<span style='color:red'>"+name+"</span>";
        String text = "<span style='color:red'>"+name+"</span>";
        model.addAttribute("msg",text);
        model.addAttribute("name",name);

        aService.a();

        //路徑式動態的
        model.addAttribute("imgUrl","/4.jpg");
        //數據庫查出的樣式
        model.addAttribute("style","width: 400px;high 400px;");
        model.addAttribute("show",false);


        return "welcome";
    }
    /**
     * 来到首页
     * @return
     */
    @GetMapping({"", "/", "welcome","/home"})
    public String index(){

        return "index";
    }

    @GetMapping("/list")
    public String list( Model model){
        List<Person> list = Arrays.asList(
                new Person(1L,"Jojo1","tert01@gmail.com",18,"pm"),
                new Person(3L,"Jojo2","tert02@gmail.com",21,"pm"),
                new Person(5L,"Jojo3","tert03@gmail.com",17,"pg"),
                new Person(6L,"Jojo4 東方仗住","",31,"pg"),
                new Person(7L,"Jojo5","tert04@gmail.com",15,"admin"),
                new Person(8L,"Jojo6","ter0t05@gmail.com",16,"hr")
                );
        model.addAttribute("persons",list);
//                int i = 10/0;
        return "list";
    }
    /**
     * 1.@ExceptionHandler 標識一個方法處理錯誤，默認只能處理這個類發生的指定錯誤。
     * 2.@ControllerAdvice 統一處理所有錯誤
     * @return e
     */
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    public  String handleExcepion(Exception e){
//
//        return "Oh~No~發生錯誤，原因是：" + e.getMessage();
//    }



}
