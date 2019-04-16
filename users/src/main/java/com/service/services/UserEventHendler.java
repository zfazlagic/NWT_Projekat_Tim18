package com.service.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class UserEventHendler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RabbitTemplate rabbitTemplate;
    private Queue candidateQueue;

    @Autowired
    public UserEventHendler(RabbitTemplate rabbitTemplate, Queue candidateQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.candidateQueue = candidateQueue;
    }

    @HandleAfterCreate
    public void handleUserSave(User user) {
        sendMessage(user);
    }

    private void sendMessage(User user) {
        rabbitTemplate.convertAndSend(
                candidateQueue.getName(), serializeToJson(user));
    }

    private String serializeToJson(User user) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }
}
