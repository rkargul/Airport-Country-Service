package com.assignment.lunatech.controller;

import com.assignment.lunatech.domain.consumed.Country;
import com.assignment.lunatech.domain.served.CountryServed;
import com.assignment.lunatech.domain.served.SummaryResponse;
import com.assignment.lunatech.services.AirportService;
import com.assignment.lunatech.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countryairportsummary")
public class SummaryController {
    private static final Logger log = LoggerFactory.getLogger(SummaryController.class);
    private final CountryService countryService;
    private final AirportService airportService;

    public SummaryController(CountryService countryService, AirportService airportService) {
        this.countryService = countryService;
        this.airportService = airportService;
    }

    @GetMapping()
    public SummaryResponse allCountriesServed(@RequestParam(value = "runways", defaultValue = "0") int runwayCount) {
        if (runwayCount < 0) {
            return new SummaryResponse(403, "Runways cannot be less than 0", null);
        }
        List<Country> countries = countryService.getAllCountries();

        List<CountryServed> countriesServed_list = countries
                .stream()
                .map(one -> new CountryServed(
                                one.getCode(),
                                one.getName(),
                                airportService.mapToServe(
                                        airportService.getAirportsPerCountry(one.getCode()), runwayCount)
                        )
                )
                .filter(one -> one.getAirports().size() > 0)
                .collect(Collectors.toList());

        return new SummaryResponse(200, null, countriesServed_list);
    }

}
