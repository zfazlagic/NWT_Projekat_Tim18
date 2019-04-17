package com.service.configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableRabbit
public class UserConfiguration {
    @Bean(name="userCreated")
    public Queue userQueue() {
        return new Queue("userCreated.queue");
    }

    @Bean(name="carCreated")
    public Queue carCreatedQueue() {

        return new Queue("carCreated.queue");

    }
}
