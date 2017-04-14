package com.demo.service.impl;

import com.demo.exception.RetryException;
import com.demo.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.reflect.ReflectionWorld;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by huguoju on 2017/4/13.
 */
@Service("retryService")
@Slf4j
public class RetryServiceImpl implements RetryService {
    int i=1;
    @Override
    @Retryable(value = {RuntimeException.class},maxAttempts = 4)
    public String retry() {
        log.info("测试retry");
        i++;
        if(i==6){
            return i+"";
        }
        RetryException retryException=RetryException.builder().code("111").message("cuowu").build();
        throw retryException;
    }
    @Recover
    public String recover(RetryException e){
        log.info(e.getMessage());
        return "6";
    }
}
