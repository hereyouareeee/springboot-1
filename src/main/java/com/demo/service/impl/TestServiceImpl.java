package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by huguoju on 2016/12/29.
 */
@Service("testService")
@Transactional
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


    @Override
    public void testTransaction() throws Exception {
        final User user1=User.builder()
                .userCode(11112)
                .isOldUser("1")
                .userName("测试")
                .userStyle(1)
                .userType("1")
                .createdDate(new Date())
                .updatedDate(new Date())
                .isDeleted((short) 0)
                .mobileNumber("18311111111").build();
          userMapper.insert(user1);
        throw new RuntimeException("插入失败");
    }
}
