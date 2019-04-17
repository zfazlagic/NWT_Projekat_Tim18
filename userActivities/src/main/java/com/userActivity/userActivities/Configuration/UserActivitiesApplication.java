package com.userActivity.userActivities.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.userActivity.userActivities.Configuration.controllers.activityDetailsController;
import com.userActivity.userActivities.Configuration.controllers.userActivityController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@ComponentScan(basePackageClasses= userActivityController.class)
@ComponentScan(basePackageClasses= activityDetailsController.class)
@EnableDiscoveryClient
@EntityScan("com/userActivity/userActivities/Configuration/models")
@ComponentScan("com.userActivity.userActivities.Configuration.services")
@EnableJpaRepositories("com.userActivity.userActivities.Configuration.repositories")
@SpringBootApplication
public class UserActivitiesApplication {

    private static final Logger log = LoggerFactory.getLogger(UserActivitiesApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(UserActivitiesApplication.class, args);

    }


//    @Bean
//    public CommandLineRunner demo(activityRepository repository, activityDetailsRepository detailRepo) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new activity(151, 22, 1, 0));
//            repository.save(new activity(555, 45, 1, 0));
//            repository.save(new activity(456, 54, 1, 0));
//
//            Date now = new Date();
//            detailRepo.save(new activityDetails(now, now, "Sarajevo", 1));
//            detailRepo.save(new activityDetails(now, now, "Sarajevo", 2));
//            detailRepo.save(new activityDetails(now, now, "Sarajevo", 3));
//            // fetch all customers
//            log.info("User Activities found with findAll():");
//            log.info("-------------------------------");
//            for (activity ac : repository.findAll()) {
//                log.info(ac.toString());
//            }
//            log.info("end");
//
//        };
//    }

//
//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
//        for (HttpMessageConverter<?> converter : converters) {
//            if (converter instanceof MappingJackson2HttpMessageConverter) {
//                MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
//                jsonConverter.setObjectMapper(new ObjectMapper());
//                jsonConverter.setSupportedMediaTypes(ImmutableList.of(new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("text", "javascript", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
//            }
//        }
//        return restTemplate;
//

//		};
//	}

    @LoadBalanced
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


//	@RestController
//	public static class ServiceInstanceRestController {
//		@Autowired
//		private DiscoveryClient discoveryClient;
//
//		@RequestMapping("/service-instances/{applicationName}")
//		public List<ServiceInstance> serviceInstancesByApplicationName(
//				@PathVariable String applicationName) {
//			return this.discoveryClient.getInstances(applicationName);
//		}
//	}
    }
}
