package com.demo.controller;

import com.demo.rabbitmq.sender.ContractRabbitMq;
import com.demo.service.rabbitMq.ContractRabbitmqService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by huguoju on 2017/3/6.
 */
@RestController
@RequestMapping("rabbitmq")
@Api(value = "测试rabbitmq",tags = "测试rabbitmq")
public class RabbitMqController {

    @Autowired
    public ContractRabbitmqService contractRabbitmqService;
    @RequestMapping(value = "contract/topic",method = {RequestMethod.POST,RequestMethod.GET})
    public void contractTopic(){
        ContractRabbitMq mq=new ContractRabbitMq();
        mq.setId("15");
        mq.setName("测试");
        mq.setTestList(Lists.newArrayList("111","222"));
        mq.setCreateDate(new Date());
        contractRabbitmqService.sendContractRabbitmqTopic(mq);
    }
}
