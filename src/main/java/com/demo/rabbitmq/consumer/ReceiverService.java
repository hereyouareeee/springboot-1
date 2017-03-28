package com.demo.rabbitmq.consumer;

import com.demo.rabbitmq.sender.ContractRabbitMq;
import com.demo.rabbitmq.sender.RabbitMqQueue;
import com.demo.rabbitmq.sender.TenantRabbitMq;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by huguoju on 2017/3/3.
 */
@Component
public class ReceiverService {
    @RabbitListener(queues = RabbitMqQueue.CONTRACE_SELF)
    @RabbitHandler
    public void receiveContractQueue(ContractRabbitMq contract) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            System.out.println("Received contract<" + objectMapper.writeValueAsString(contract) + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = RabbitMqQueue.CONTRACE_TENANT)
    public void receiveTenantQueue(TenantRabbitMq tenant) {
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            System.out.println("Received contract<" + objectMapper.writeValueAsString(tenant) + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
