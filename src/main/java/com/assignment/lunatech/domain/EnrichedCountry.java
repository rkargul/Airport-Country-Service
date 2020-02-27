package com.assignment.lunatech.domain;

import java.util.HashMap;

public class EnrichedCountry {

    private String country_name;
    private String country_id;
    private HashMap<String, Airport> airports_map; //key: country_id ; value: airport;

    public EnrichedCountry (String country_id, String country_name) {
        this.country_id = country_id;
        this.country_name = country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
