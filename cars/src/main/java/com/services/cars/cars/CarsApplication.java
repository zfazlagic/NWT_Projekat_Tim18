package com.services.cars.cars;

import com.cars.controller.CarControler;
import com.cars.model.Cars;
import com.cars.repository.CarsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.services"})
@EntityScan("com.cars.model")
@EnableJpaRepositories("com.cars.repository")
@ComponentScan(basePackageClasses= CarControler.class)
public class CarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner addNewCars(CarsRepository cars){
		return (args )->{
			cars.save(new Cars("Audi",true,false));
			cars.save(new Cars("Mercedes", false,true));
			cars.save(new Cars("BMW", false,false));

		};
	}*/


}
