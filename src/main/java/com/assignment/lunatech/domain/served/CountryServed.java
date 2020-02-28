package com.assignment.lunatech.domain.served;

import java.util.List;

public class CountryServed {

    private String id;
    private String name;
    private List<AirportServed> airports;

    public CountryServed(String id, String name, List<AirportServed> airports) {
        this.id = id;
        this.name = name;
        this.airports = airports;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AirportServed> getAirports() {
        return airports;
    }
}
