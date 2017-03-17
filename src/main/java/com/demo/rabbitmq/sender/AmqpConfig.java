package com.demo.rabbitmq.sender;


import com.demo.model.RabbitMq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * Created by huguoju on 2017/3/2.
 * 创建消息生产者
 */
@Configuration
@Slf4j
public class AmqpConfig {
    @Autowired
    private RabbitMq rabbitMq;

    /**
     * 连接rabbitmq
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitMq.getAddresses());
        connectionFactory.setUsername(rabbitMq.getUsername());
        connectionFactory.setPassword(rabbitMq.getPassword());
        /**
         * 对于每一个RabbitTemplate只支持一个ReturnCallback。
         * 对于返回消息，模板的mandatory属性必须被设定为true，
         * 它同样要求CachingConnectionFactory的publisherReturns属性被设定为true。
         * 如果客户端通过调用setReturnCallback(ReturnCallback callback)注册了RabbitTemplate.ReturnCallback，那么返回将被发送到客户端。
         * 这个回调函数必须实现下列方法：
         *void returnedMessage(Message message, intreplyCode, String replyText,String exchange, String routingKey);
         */
       // connectionFactory.setPublisherReturns(true);
        /**
         * 同样一个RabbitTemplate只支持一个ConfirmCallback。
         * 对于发布确认，template要求CachingConnectionFactory的publisherConfirms属性设置为true。
         * 如果客户端通过setConfirmCallback(ConfirmCallback callback)注册了RabbitTemplate.ConfirmCallback，那么确认消息将被发送到客户端。
         * 这个回调函数必须实现以下方法：
         * void confirm(CorrelationData correlationData, booleanack);
         */
        connectionFactory.setPublisherConfirms(rabbitMq.getPublisherconfirms());
        return connectionFactory;
    }

    /**
     * rabbitAdmin代理类
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 创建rabbitTemplate 消息模板类
     * prototype原型模式:每次获取Bean的时候会有一个新的实例
     *  因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate=new RabbitTemplate(connectionFactory());
       // rabbitTemplate.setMandatory(true);//返回消息必须设置为true
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());//数据转换为json存入消息队列
      //  rabbitTemplate.setReplyAddress(replyQueue().getName());
      //  rabbitTemplate.setReplyTimeout(100000000);
        //发布确认
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            //消息发送到queue时就执行
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                log.debug(correlationData+"//////");
                if (!b){
                    log.debug("发送到queue失败");
                    throw new RuntimeException("send error " + s);
                }
            }
        });
        return rabbitTemplate;
    }
}
