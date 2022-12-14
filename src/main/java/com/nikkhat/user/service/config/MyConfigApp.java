package com.nikkhat.user.service.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class MyConfigApp {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
