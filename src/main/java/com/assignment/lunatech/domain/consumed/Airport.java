package com.assignment.lunatech.domain.consumed;

import com.assignment.lunatech.domain.Runway;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {

    private String ident;
    private String name;
    private String iso_country;
    private Runway[] runways;

    public String getIdent() {
        return ident;
    }

    public String getName() {
        return name;
    }

    public Runway[] getRunways() {
        return runways;
    }

    public String getIso_country() {
        return iso_country;
    }
}
