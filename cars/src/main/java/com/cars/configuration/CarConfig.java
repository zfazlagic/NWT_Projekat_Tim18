package com.cars.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EntityScan(basePackages = {"<model>"})
@Configuration
public class CarConfig {
    @Bean
    public Queue carQue() {
        return new Queue("candidates.queue");
    }
}
