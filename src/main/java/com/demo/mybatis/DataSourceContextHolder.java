package com.demo.mybatis;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by huguoju on 2016/12/29.
 * 本地线程全局变量
 */
@Slf4j
public class DataSourceContextHolder  {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {

        local.set(DataSourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        log.debug("writewritewrite");
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }
}
