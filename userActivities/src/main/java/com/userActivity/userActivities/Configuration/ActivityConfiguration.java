package com.userActivity.userActivities.Configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Queue;

public class ActivityConfiguration {
    @Bean
    public Queue carQueue() {
        System.out.println(("queue sam"));
        return new Queue("carCreated.queue");
    }
@Bean
    public Queue userQueue() {
        System.out.println(("queue sam"));
        return new Queue("userCreated.queue");
    }
}
