package com.assignment.lunatech.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnrichedCountry {

    private String name;
    private String ident;
    private HashMap<String, Airport> airports_map; //<ident country, airport>>

    public EnrichedCountry (String ident, String name) {
        this.ident = ident;
        this.name = name;
    }
}
