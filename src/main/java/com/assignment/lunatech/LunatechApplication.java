package com.assignment.lunatech;

import com.assignment.lunatech.domain.Airport;
import com.assignment.lunatech.controller.SummaryController;
import com.assignment.lunatech.domain.Country;
import com.assignment.lunatech.domain.EnrichedCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@SpringBootApplication
public class LunatechApplication {

    private Country[] countries;
    private Airport[] airports;

    private static final Logger log = LoggerFactory.getLogger(LunatechApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LunatechApplication.class, args);
    }

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            // List of countries
            Country[] countries = restTemplate.getForObject("http://192.168.99.100:8086/countries", Country[].class);

            HashMap<String, Country> country_map = new HashMap<>();
            for(Country country : countries) {
                country_map.put(country.getCode(), country);
            }

//            SummaryController.getCountry(countries[1].getName());

            // List of airports
            airports = restTemplate.getForObject("http://192.168.99.100:8085/airports", Airport[].class);

            HashMap<String, Airport> airport_map = new HashMap();
            for(Airport air : airports) {
                airport_map.put(air.getIdent(), air);
            }


//             Put all airports and country into a enrichedCountries
//            HashMap<String, EnrichedCountry> enrichedCountries_map = new HashMap();
//            for(Country country : countries) {
//                EnrichedCountry enrichedCountry = new EnrichedCountry(country.getCode(),country.getName());
//                enrichedCountries_map.put(country.getCode(), enrichedCountry);
//            }

        };
    }

}
