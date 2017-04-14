package com.demo.service.impl;

import com.demo.exception.RetryException;
import com.demo.mapper.UserMapper;
import com.demo.model.User;
import com.demo.service.RetryService;
import com.demo.service.TestService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;

/**
 * Created by huguoju on 2016/12/29.
 */
@Service("testService")
@Transactional
@Slf4j
public class TestServiceImpl implements TestService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RetryService retryService;
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

    @Override
    public Map testRetry() {
        Map map= Maps.newHashMap();
        String s=retryService.retry();
        if (s.equals("6")){
            log.info("成功啦啦啦啦啦啦啦啦");
        }else {
            log.info("kaokaokao");
        }
        map.put("result",s);
        return map;
    }
}
