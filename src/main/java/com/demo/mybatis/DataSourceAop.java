package com.demo.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by huguoju on 2016/12/29.
 * 拦截设置本地线程变量
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {
    @Before("execution(* com.demo.mapper..*.select*(..)) || execution(* com.demo.mapper..*.get*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("dataSource切换到：Read");
    }

    @Before("execution(* com.demo.mapper..*.insert*(..)) || execution(* com.demo.mapper..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("dataSource切换到：write");
    }
}
