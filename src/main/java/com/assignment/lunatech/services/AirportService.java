package com.assignment.lunatech.services;

import com.assignment.lunatech.domain.consumed.Airport;
import com.assignment.lunatech.domain.served.AirportServed;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final RestTemplate restTemplate;

    public AirportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Airport> getAllAirports() {
        Airport[] airports = restTemplate.getForObject("http://192.168.99.100:8086/airports", Airport[].class);
        return Arrays.asList(airports);
    }

    public List<Airport> getAirportsPerCountry(@PathVariable String iso_country) {
        Airport[] airports = restTemplate.getForObject("http://192.168.99.100:8086/search/" + iso_country, Airport[].class);
        return Arrays.asList(airports);
    }

    public List<AirportServed> mapToServe(List<Airport> airports, int runwaysNum) {
        return airports
                .stream()
                .filter(one -> one.getRunways().length >= runwaysNum)
                .map(one -> new AirportServed(one.getIdent(), one.getName(),

                        one.getRunways().length))
                .collect(Collectors.toList());
    }
}
