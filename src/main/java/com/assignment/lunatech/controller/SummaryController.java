package com.assignment.lunatech.controller;

import com.assignment.lunatech.domain.consumed.Country;
import com.assignment.lunatech.domain.served.CountryServed;
import com.assignment.lunatech.domain.served.SummaryResponse;
import com.assignment.lunatech.services.AirportService;
import com.assignment.lunatech.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countryairportsummary")
public class SummaryController {
    private static final Logger log = LoggerFactory.getLogger(SummaryController.class);
    private final CountryService countryService;
    private final AirportService airportService;

    private final HashMap<String, CountryServed> served;

    public SummaryController(CountryService countryService, AirportService airportService, HashMap<String, CountryServed> served) {
        this.countryService = countryService;
        this.airportService = airportService;
        this.served = served;
    }

    @GetMapping()
    public SummaryResponse allCountriesServed(@RequestParam(value = "runways", defaultValue = "0") int runwayCount) {
        if (runwayCount < 0) {
            return new SummaryResponse(403, "Runways cannot be less than 0", null);
        }

        List<CountryServed> countries = new ArrayList<>(served.values());

        List<CountryServed> countriesServed_list = countries
                .stream()
                .map(one -> new CountryServed(
                                one.getId(),
                                one.getName(),
                                airportService.mapToServe(
                                        airportService.getAirportsPerCountry(one.getId()), runwayCount)
                        )
                )
                .filter(one -> one.getAirports().size() > 0)
                .collect(Collectors.toList());

        return new SummaryResponse(200, null, countriesServed_list);
    }
}
