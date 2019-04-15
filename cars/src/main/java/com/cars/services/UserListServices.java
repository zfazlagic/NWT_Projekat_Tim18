package com.cars.services;
import com.cars.model.User;
import com.cars.repository.UsersRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


import java.io.IOException;

public class UserListServices {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UsersRepository userRepository;


    @RabbitListener(queues = "#{userCreatedQueue.name}")

    public void getCandidateMessage(String userCreatedMessage) {
        logger.info(userCreatedMessage);
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            user = objectMapper.readValue(userCreatedMessage, User.class);

            //user = objectMapper.readValue(userCreatedMessage, mapType);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
