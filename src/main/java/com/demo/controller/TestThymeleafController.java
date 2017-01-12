package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by huguoju on 2017/1/6.
 */
@Controller
@RequestMapping("/thymeleaf")
public class TestThymeleafController {
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","from TestThymeleafController.hello");
        return"/hello";
    }
}
