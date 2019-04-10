package com.services.cars.cars;

import com.cars.controller.CarControler;
import com.cars.model.Cars;
import com.cars.repository.CarsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;



@EnableDiscoveryClient
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
@Bean
public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate();
	List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
	for (HttpMessageConverter<?> converter : converters) {
		if (converter instanceof MappingJackson2HttpMessageConverter) {
			MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
			jsonConverter.setObjectMapper(new ObjectMapper());
			jsonConverter.setSupportedMediaTypes(ImmutableList.of(new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("text", "javascript", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
		}
	}
	return restTemplate;


}
}
