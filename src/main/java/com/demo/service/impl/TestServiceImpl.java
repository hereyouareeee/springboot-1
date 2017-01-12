package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huguoju on 2016/12/29.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserCode(Integer userCode) {
        return userMapper.selectByPrimaryKey(userCode);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insert(user);
    }
}
