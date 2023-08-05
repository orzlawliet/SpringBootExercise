package com.lawliet.boot3.features;

import com.lawliet.boot3.features.service.HelloService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

//測試類也必須在主程序所在的包及其子包
@SpringBootTest //具備測試SpringBoot應用容器中所有組件的功能
class Boot306FeaturesApplicationTests {


    @Autowired //自動注入任意組件即可測試
    HelloService helloService;

    @BeforeAll  //所有測試方法運行之前先運行這個 ： 只打印一次
    static void initAll() {
        System.out.println("hello");
    }

    @BeforeEach //每個測試方法運行之前先運行這個 ： 每個方法運行打印一次
    void init() {
        System.out.println("world");
    }


    @DisplayName("test01")
    @Test
    void contextLoads() {
        int sum = helloService.sum(1,2);
        Assertions.assertEquals(3,sum);
        System.out.println("sum："+sum);
    }
    @DisplayName("😱")
    @Test
    void test01() {
        System.out.println("aaa");
    }

    @ParameterizedTest //參數化測試
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

    @ParameterizedTest
    @MethodSource("method")    //指定方法名,返回值就是測試用的參數
    @DisplayName("方法來源參數")
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }


    //返回Stream即可
    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }
}
