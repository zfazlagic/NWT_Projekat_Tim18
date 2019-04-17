package com.service.users;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.service.entities.User;
import org.json.JSONObject;
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
public class UsersApplicationTests {

	private RestTemplate restTemplate=new RestTemplate();

	@Test
	public void contextLoads() {
	}

	@Test
	public void postUser() throws Exception {

		User ac = new User("student","novi","sifra212");

		JSONObject js=new JSONObject();
		js.put("role", "student");
		js.put("username", "novi");
		js.put("password", "sifra212");

		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.out.println(js.toString());
		ResponseEntity<User> p=restTemplate.exchange(
				"http://localhost:8081/add",
				HttpMethod.POST, new HttpEntity<Object>(ac, headers), User.class);
		assertThat(p.getStatusCode().value()==200).isTrue();
		assertThat(p.getBody().getUsername()).isEqualTo("novi");

	}

}

