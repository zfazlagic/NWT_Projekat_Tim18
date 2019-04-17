package com.userActivity.userActivities.Configuration.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userActivity.userActivities.Configuration.models.Cars;
import com.userActivity.userActivities.Configuration.models.User;
import com.userActivity.userActivities.Configuration.repositories.CarRepository;
import com.userActivity.userActivities.Configuration.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarListService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CarRepository carRepository;


    @RabbitListener(queues = "carCreated.queue")
    public void getCandidateMessage(String carCreatedMessage) {
        System.out.println("proba");
        logger.info(carCreatedMessage);
        ObjectMapper objectMapper = new ObjectMapper();
        Cars car = null;
        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            car = objectMapper.readValue(carCreatedMessage, Cars.class);

            carRepository.save(car);
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
