package com.demo.service;

import com.demo.model.User;

/**
 * Created by huguoju on 2016/12/29.
 */
public interface TestService {
    User selectByUserCode(Integer userCode);
    Integer insertUser(User user);
}
