package com.cars.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener
public class CarConfig {

    @Bean
    public Queue carQueue() {
        System.out.println(("queue sam"));
        return new Queue("userCreated.queue");
    }

}