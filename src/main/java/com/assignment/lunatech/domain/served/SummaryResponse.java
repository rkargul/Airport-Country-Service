package com.assignment.lunatech.domain.served;

import java.util.List;

public class SummaryResponse {
    private int code;
    private String message;
    private List<CountryServed> countryServeds;

    public SummaryResponse(int code, String message, List<CountryServed> countryServeds) {
        this.code = code;
        this.message = message;
        this.countryServeds = countryServeds;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<CountryServed> getCountryServeds() {
        return countryServeds;
    }

}
