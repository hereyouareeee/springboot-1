package com.demo.rabbitmq.sender;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huguoju on 2017/3/2.
 * 交换机配置并绑定queue
 */
@Configuration
public class ContractExchangeConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    /**
     * 不处理路由键。你只需要简单的将队列绑定到交换机上。一个发送到交换机的消息都会被转发到与该交换机绑定的所有队列上。很像子网广播，每台子网内的主机都获得了一份复制的消息。Fanout交换机转发消息是最快的。
     * @return
     */
//    @Bean
//    FanoutExchange contractFanoutExchange(){
//        FanoutExchange fanoutExchange=new FanoutExchange(RabbitMqExchange.CONTRACT_FANOUT);
//        rabbitAdmin.declareExchange(fanoutExchange);
//        return fanoutExchange;
//    }

    /**
     *  将路由键和某模式进行匹配。此时队列需要绑定要一个模式上。符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但是“audit.*” 只会匹配到“audit.irs”
     *  默认：, durable = true, autoDelete = false
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable(){
        TopicExchange contractTopicExchange=new TopicExchange(RabbitMqExchange.CONTRACT_TOPIC);
        rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }

    /**
     *  处理路由键。需要将一个队列绑定到交换机上，要求该消息与一个特定的路由键完全匹配。这是一个完整的匹配。如果一个队列绑定到该交换机上要求路由键 “dog”，则只有被标记为“dog”的消息才被转发，不会转发dog.puppy，也不会转发dog.guard，只会转发dog
     * @return
     */
    @Bean
    DirectExchange contractDirectExchange(){
        DirectExchange contractDirectExchange=new DirectExchange(RabbitMqExchange.CONTRACT_DIRECT);
        rabbitAdmin.declareExchange(contractDirectExchange);
        return contractDirectExchange;
    }
    @Bean
    Queue queueContract(){
        Queue queue=new Queue(RabbitMqQueue.CONTRACE_SELF,true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }
    @Bean
    Queue queueTenant(){
        Queue queue=new Queue(RabbitMqQueue.CONTRACE_TENANT,true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

//    @Bean
//    Binding bindingExchangeContract(Queue queueContract,FanoutExchange exchange){
//        Binding binding=BindingBuilder.bind(queueContract).to(exchange);
//        rabbitAdmin.declareBinding(binding);
//        return binding;
//    }
    @Bean
    Binding bindingExchangeContract(Queue queueContract,TopicExchange exchange){
        Binding binding=BindingBuilder.bind(queueContract).to(exchange).with(RabbitMqQueue.CONTRACE_SELF);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }
//    @Bean
//    Binding bindingExchangeContract(Queue queueContract,DirectExchange exchange){
//        Binding binding=BindingBuilder.bind(queueContract).to(exchange).with(RabbitMqQueue.CONTRACE_SELF);
//        rabbitAdmin.declareBinding(binding);
//        return binding;
//    }
    @Bean
    Binding bindingExchangeTenant(Queue queueTenant, TopicExchange exchange) {
        Binding binding = BindingBuilder.bind(queueTenant).to(exchange).with(RabbitMqQueue.CONTRACE_TENANT);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

//    @Bean
//    Binding bindingExchangeTenant(Queue queueTenant, DirectExchange exchange) {
//        Binding binding = BindingBuilder.bind(queueTenant).to(exchange).with(RabbitMqQueue.CONTRACE_TENANT);
//        rabbitAdmin.declareBinding(binding);
//        return binding;
//    }

}
