package com.cars.services;

import com.cars.model.Cars;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CarEventHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RabbitTemplate rabbitTemplate;
    private Queue candidateQueue;

    @Autowired
    public CarEventHandler(RabbitTemplate rabbitTemplate,@Qualifier("carCreated")Queue candidateQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.candidateQueue = candidateQueue;
    }

    @HandleAfterCreate
    public void handleCarSave(Cars car) {
        sendMessage(car);
    }

    private void sendMessage(Cars car) {
        rabbitTemplate.convertAndSend(
                candidateQueue.getName(), serializeToJson(car));
    }

    private String serializeToJson(Cars car) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }
}
