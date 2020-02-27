package com.assignment.lunatech.controller;

import com.assignment.lunatech.domain.Airport;
import com.assignment.lunatech.domain.Country;
import com.assignment.lunatech.domain.EnrichedCountry;
import com.assignment.lunatech.services.AirportService;
import com.assignment.lunatech.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SummaryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private AirportService airportService;

    @GetMapping("")
    public Country[] displayAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/search/{countryID}")
    public Airport[] displayAirportsInCountry(@PathVariable String countryID) {
        return airportService.getAirportsPerCountry(countryID);
    }

    @GetMapping("/all")
    public Airport[] displayAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/allcountries")
    public EnrichedCountry[] enrichedCountriesWithOneOrMore() {
        Country[] countries = countryService.getAllCountries();
        EnrichedCountry[] enrichedCountries1 = new EnrichedCountry[countries.length];
        for(int i = 0; i < countries.length; i++) {
            enrichedCountries1[i] = new EnrichedCountry(countries[i].getCode(), countries[i].getName());
        }
        return enrichedCountries1;
    }
}
