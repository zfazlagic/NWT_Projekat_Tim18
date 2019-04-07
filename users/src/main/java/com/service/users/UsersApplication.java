package com.service.users;

import com.service.entities.User;
import com.service.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.service"})
@EntityScan("com.service.entities")
@EnableJpaRepositories("com.service.repositories")
public class UsersApplication {

    private static final Logger log = LoggerFactory.getLogger(UsersApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("Admin", "dcosic", "sifra123"));
            repository.save(new User("Client", "zfazlagic", "sifra123"));
            repository.save(new User("Client", "dmusinovic", "sifra123"));
            repository.save(new User("Client", "nnikic", "sifra123"));
            //repository.save(new User("Client", "ttestic", "sifra"));


            // fetch all customers
            log.info("Users found with getAllUsers():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(user -> {
                        log.info("User found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(user.toString());
                        log.info("");
                    });

            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }*/
}
