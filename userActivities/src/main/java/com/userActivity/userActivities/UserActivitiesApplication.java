package com.userActivity.userActivities;

import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.*;



@EntityScan("models")
@EnableJpaRepositories("repositories")
@SpringBootApplication
public class UserActivitiesApplication {

	private static final Logger log = LoggerFactory.getLogger(UserActivitiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserActivitiesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(activityRepository repository, activityDetailsRepository detailsRepository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new activity(1, 2, 1, 0));
			repository.save(new activity(5, 4, 1, 0));
			repository.save(new activity(5, 4, 1, 0));

			// fetch all customers
			log.info("User Activities found with findAll():");
			log.info("-------------------------------");
			for (activity ac : repository.findAll()) {
				log.info(ac.toString());
			}
			log.info("end");

		};
	}
}

