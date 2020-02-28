package com.assignment.lunatech;

import com.assignment.lunatech.domain.served.CountryServed;
import com.assignment.lunatech.services.AirportService;
import com.assignment.lunatech.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@SpringBootApplication
public class LunatechApplication {

    private final CountryService countryService;
    public final AirportService airportService;
    private final HashMap<String, CountryServed> served;

    private static final Logger log = LoggerFactory.getLogger(LunatechApplication.class);

    public LunatechApplication(CountryService countryService, AirportService airportService, HashMap<String, CountryServed> served) {
        this.countryService = countryService;
        this.airportService = airportService;
        this.served = served;
    }

    public static void main(String[] args) {
        SpringApplication.run(LunatechApplication.class, args);
    }

    @PostConstruct
    public void loadCountries() {
        log.info("Loading countries...");
        countryService.getAllCountries()
                .stream()
                .map(one -> new CountryServed(
                                one.getCode(),
                                one.getName(),
                                airportService.mapToServe(
                                        airportService.getAirportsPerCountry(one.getCode()), 0)
                        )
                )
                .filter(one -> one.getAirports().size() > 0)
                .forEach(item -> served.put(item.getId(), item));
        log.info("Countries loaded!");
    }
}
