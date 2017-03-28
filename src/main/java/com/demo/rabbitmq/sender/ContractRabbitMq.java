package com.demo.rabbitmq.sender;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

/**
 * Created by huguoju on 2017/3/3.
 * 合同消息载体
 */
//@Builder
//@Getter
@Data
public class ContractRabbitMq {
    private String id;
    private String name;
    private List<String> testList;
    private Date createDate;
}
