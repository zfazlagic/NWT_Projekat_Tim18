package com.userActivity.userActivities.Configuration.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userActivity.userActivities.Configuration.models.User;
import com.userActivity.userActivities.Configuration.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserListService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;


    @RabbitListener(queues = "userCreated.queue")
    public void getCandidateMessage(String userCreatedMessage) {
        System.out.println("proba");
        logger.info(userCreatedMessage);
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            user = objectMapper.readValue(userCreatedMessage, User.class);

            userRepository.save(user);
            System.out.println("proba");
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
