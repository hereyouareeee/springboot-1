package com.demo.service.rabbitMq;

import com.demo.rabbitmq.sender.ContractRabbitMq;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by huguoju on 2017/3/3.
 */
public class ContractRabbitmqServiceTest {
    @Autowired
    private ContractRabbitmqService contractRabbitmqService;
    @Test
    public void sendContractRabbitmqTopic() {
        ContractRabbitMq mq=new ContractRabbitMq();
        mq.setId("15");
        mq.setName("测试");
        mq.setTestList(Lists.newArrayList("111","222"));
        mq.setCreateDate(new Date());
        contractRabbitmqService.sendContractRabbitmqTopic(mq);
    }

}