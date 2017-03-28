package com.demo.rabbitmq.sender;

/**
 * Created by huguoju on 2017/3/2.
 * exchange交换机配置
 */
public interface RabbitMqExchange {
    final String CONTRACT_FANOUT = "CONTRACT_FANOUT";
    final String CONTRACT_TOPIC = "CONTRACT_TOPIC";
    final String CONTRACT_DIRECT = "CONTRACT_DIRECT";
}
