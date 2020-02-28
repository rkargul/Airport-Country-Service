package com.assignment.lunatech.domain;

import com.assignment.lunatech.domain.consumed.Airport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnrichedCountry {

    private String name;
    private String ident;
    private Airport[] airports;

    public EnrichedCountry (String ident, String name, Airport[] list) {
        this.ident = ident;
        this.name = name;
        this.airports = list;
    }

    public String getName() {
        return name;
    }

    public String getIdent() {
        return ident;
    }

    public Airport[] getAirports() {
        return airports;
    }

    @Override
    public String toString() {
        return "EnrichedCountry{" +
                "name='" + name + '\'' +
                ", ident='" + ident + '\'' +
                ", airports=" + Arrays.toString(airports) +
                '}';
    }
}
