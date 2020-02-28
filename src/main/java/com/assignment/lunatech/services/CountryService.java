package com.assignment.lunatech.services;

import com.assignment.lunatech.domain.consumed.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Country> getAllCountries() {
        Country[] countries = restTemplate.getForObject("http://192.168.99.100:8085/countries", Country[].class);
        return Arrays.asList(countries);
    }

}
