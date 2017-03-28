package com.demo.service.rabbitMq;

import com.demo.rabbitmq.sender.ContractRabbitMq;
import com.demo.rabbitmq.sender.RabbitMqExchange;
import com.demo.rabbitmq.sender.RabbitMqQueue;
import com.demo.rabbitmq.sender.TenantRabbitMq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by huguoju on 2017/3/3.
 * rabbitmq发送消息
 */

@Service
@Slf4j
public class ContractRabbitmqService {
   // @Autowired
   // private RabbitMessagingTemplate rabbitMessagingTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendContractRabbitmqTopic(final ContractRabbitMq contractRabbitMq){
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        log.debug(correlationId+"//////");
       // MessagePostProcessor postProcessor = postProcessorFactory.createPostProcessor(messageId, correlationId);
        rabbitTemplate.convertSendAndReceive(RabbitMqExchange.CONTRACT_TOPIC, RabbitMqQueue.CONTRACE_SELF,contractRabbitMq,correlationId);
    }
    public void sendContractRabbitmqDirect(final ContractRabbitMq ContractRabbitmq) {
        rabbitTemplate.convertAndSend(RabbitMqExchange.CONTRACT_DIRECT, RabbitMqQueue.CONTRACE_SELF, ContractRabbitmq);
    }

    public void sendTenantRabbitmqTopic(final TenantRabbitMq tenantRabbitmq){
        rabbitTemplate.convertAndSend(RabbitMqExchange.CONTRACT_TOPIC, RabbitMqQueue.CONTRACE_TENANT, tenantRabbitmq);
    }


    public void sendTenantRabbitmqDirect(final TenantRabbitMq tenantRabbitmq){
        rabbitTemplate.convertAndSend(RabbitMqExchange.CONTRACT_DIRECT, RabbitMqQueue.CONTRACE_TENANT, tenantRabbitmq);
    }
}
