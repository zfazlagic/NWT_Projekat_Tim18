package com.service.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.service.entities.UserActivity;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;


@RefreshScope
@RestController
public class UserActivityController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${service.usersService.serviceId}")
    private String userActivityServiceId;

    @RequestMapping("/useractivity/{myself}")
    public UserActivity findme(@PathVariable Long myself)
    {
        Application application = eurekaClient.getApplication(userActivityServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        System.out.println(instanceInfo +"INSTANCE INFOOO");
        String url = "http://USERACTIVITY/activities/"+myself;
        //String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "activities/" + myself;
        System.out.println("URL" + url);
        //ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserActivity emp = restTemplate.getForObject(url, UserActivity.class);
        System.out.println(restTemplate.getForObject(url, UserActivity.class));
        //System.out.println("RESPONSE " + emp);
        return emp;

    }

    @RequestMapping("/useractivity/all")
    public Collection < UserActivity > findPeers() {
        Application application = eurekaClient.getApplication(userActivityServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://USERACTIVITY/activities/";
        System.out.println("URL" + url);
        Collection < UserActivity > list = restTemplate.getForObject(url, Collection.class);
        System.out.println("RESPONSE " + list);
        return list;
    }




}
