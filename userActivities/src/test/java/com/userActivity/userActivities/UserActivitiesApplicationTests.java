package com.userActivity.userActivities;



import com.fasterxml.jackson.databind.SerializationFeature;
import com.userActivity.userActivities.Configuration.models.activity;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotSame;


@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class UserActivitiesApplicationTests {

	private RestTemplate restTemplate=new RestTemplate();

	@Test
	public void contextLoads() {
	}

	@Test
	public void postActivity() throws Exception {

		activity ac = new activity(1, 4, 1, 0);

		JSONObject js=new JSONObject();
		js.put("userId", "1");
		js.put("carId", "4");
		js.put("isRental", "1");
		js.put("isReservation", "0");

		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.out.println(js.toString());
		ResponseEntity<activity> p=restTemplate.exchange(
				"http://localhost:8083/activity/addActivity",
				HttpMethod.POST, new HttpEntity<Object>(ac, headers), activity.class);
		assertThat(p.getStatusCode().value()==200).isTrue();
		assertThat(p.getBody().getUserId()).isEqualTo(1);

	}

    @Test
    public void GetAll() throws Exception {
        String url="http://localhost:8083/activity/activities";
        ResponseEntity<String> response
                = restTemplate.getForEntity(url + "", String.class);
        Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
