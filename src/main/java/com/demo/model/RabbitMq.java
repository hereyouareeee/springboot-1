package com.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huguoju on 2017/3/2.
 * rabbitmq配置文件
 */
@Configuration
@Getter
@Setter
@ConfigurationProperties(locations = "classpath:rabbitmq/rabbitmq.properties",prefix = "spring.rabbitmq")
public class RabbitMq{

    private String addresses;
    private String username;
    private String password;
    private Boolean publisherconfirms;
}
