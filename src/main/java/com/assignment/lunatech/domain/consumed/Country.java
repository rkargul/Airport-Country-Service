package com.assignment.lunatech.domain.consumed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    private String code;
    private String name;

    public Country() {
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Country:" + getName() + " (code: " + getCode();
    }
}
