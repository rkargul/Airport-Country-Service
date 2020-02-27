package com.assignment.lunatech.services;

import com.assignment.lunatech.domain.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class AirportService {

    @Autowired
    private RestTemplate restTemplate;

    public Airport[] getAllAirports() {
        Airport[] airports = restTemplate.getForObject("http://192.168.99.100:8085/airports", Airport[].class);
        return airports;
    }

    public Airport[] getAirportsPerCountry(@PathVariable String iso_country) {
        Airport[] airports = restTemplate.getForObject("http://192.168.99.100:8085/search/" + iso_country, Airport[].class);
        return airports;
    }
}
