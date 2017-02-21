package com.demo.controller;

import com.demo.interceptor.Auth;
import com.demo.model.User;
import com.demo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by huguoju on 2016/12/28.
 */
@RestController
@RequestMapping("test")
@Api(value = "测试类", tags = "测试接口")
@Auth
public class TestController {

    /**
     * @Cacheable(key = "'user:'.concat(#userCode)",value = "user")
     * value的意思是当调用这个方法的时候，会从一个名叫 user 的缓存中查询，如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，否则返回缓存中的对象
     */
    @Autowired
    private TestService testService;

    @RequestMapping(value = "testData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation("测试读写分离、缓存")
    // @Cacheable(key = "'user:'.concat(#userCode)",value = "user")
    public User testDateSource(
            @ApiParam(name = "userCode", value = "用户id", required = true)
            @RequestParam Integer userCode) {
        User user = testService.selectByUserCode(userCode);
        final User user1=User.builder()
                .userCode(1111)
                .isOldUser("1")
                .userName("测试")
                .userStyle(1)
                .userType("1")
                .createdDate(new Date())
                .mobileNumber("18311111111").build();
        testService.insertUser(user1);
        return user;
    }
     @RequestMapping("/turnJsp")
    
     public String turnJsp(){
         return "login/login";
     }
}
