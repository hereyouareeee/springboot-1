package com.demo.controller;

import com.demo.service.RetryService;
import com.demo.service.TestService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by huguoju on 2017/4/13.
 */
@RestController
@RequestMapping("retry")
@Api(value = "重试机制",tags = "重试机制")
public class RetryController {
    @Autowired
    public TestService testService;
    @RequestMapping(value = "testRetry",method = {RequestMethod.POST,RequestMethod.GET},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map testRetry(){
        Map map=Maps.newHashMap();
        try {
            map= testService.testRetry();
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return map;
        }
    }
}
