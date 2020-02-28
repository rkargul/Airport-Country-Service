package com.assignment.lunatech.configuration;

import com.assignment.lunatech.domain.served.CountryServed;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@Configuration
public class beans {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


    @Bean
    public static HashMap<String, CountryServed> countrySummary() {
        return new HashMap<>();
    }
}
