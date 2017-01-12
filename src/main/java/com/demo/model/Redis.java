package com.demo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huguoju on 2016/12/29.
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.redis",locations = "classpath:redis/redis.properties")
public class Redis {

    private String database;
    private String host;
    private String password;
    private int port;
    private int timeout;
    private String maxIdle;
    private String minIdle;
    private String maxActive;
    private String maxWait;


}
