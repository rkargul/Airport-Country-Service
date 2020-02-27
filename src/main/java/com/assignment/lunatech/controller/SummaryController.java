package com.assignment.lunatech.controller;

import com.assignment.lunatech.domain.Country;
import com.assignment.lunatech.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/countryairportsummary")
public class SummaryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public Country[] displayAllCountries() {
        return countryService.getAllCountries();
    }
}
