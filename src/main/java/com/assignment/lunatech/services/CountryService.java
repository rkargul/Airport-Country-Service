package com.assignment.lunatech.services;

import com.assignment.lunatech.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    public Country[] getAllCountries() {

        // List of countries
        Country[] countries = restTemplate.getForObject("http://192.168.99.100:8086/countries", Country[].class);

        return countries;

    }
}
