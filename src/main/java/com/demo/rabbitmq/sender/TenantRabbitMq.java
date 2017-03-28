package com.demo.rabbitmq.sender;


import lombok.Builder;
import lombok.Getter;

/**
 * Created by huguoju on 2017/3/3.
 * tenant消息载体
 */
@Builder
@Getter
public class TenantRabbitMq {
    private String id;
    private String name;
}
