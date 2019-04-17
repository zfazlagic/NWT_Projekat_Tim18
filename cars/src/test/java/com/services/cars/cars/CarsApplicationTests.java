package com.services.cars.cars;

import com.cars.model.Cars;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class CarsApplicationTests {

	private RestTemplate restTemplate=new RestTemplate();
	@Test
	public void contextLoads() {
	}

	@Test
	public void postCar() throws Exception {

		Cars ac = new Cars("BMW",true,false);

		JSONObject js=new JSONObject();
		js.put("carName", "BMW");
		js.put("isEditable", "true");
		js.put("isDeletable", "false");

		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.out.println(js.toString());
		ResponseEntity<Cars> p=restTemplate.exchange(
				"http://localhost:8082/cars/addCar",
				HttpMethod.POST, new HttpEntity<Object>(ac, headers), Cars.class);
		assertThat(p.getStatusCode().value()==200).isTrue();
		assertThat(p.getBody().getCarName()).isEqualTo("BMW");

	}

}
