package com.demo.service;

import com.demo.model.User;

import java.util.Map;

/**
 * Created by huguoju on 2016/12/29.
 */
public interface TestService {
    User selectByUserCode(Integer userCode);
    Integer insertUser(User user);
    void testTransaction() throws Exception;
    Map testRetry();
}
