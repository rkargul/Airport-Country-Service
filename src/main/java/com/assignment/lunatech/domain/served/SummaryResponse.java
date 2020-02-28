package com.assignment.lunatech.domain.served;

import java.util.List;

public class SummaryResponse {
    private int code;
    private String message;
    private List<CountryServed> countryServed;

    public SummaryResponse(int code, String message, List<CountryServed> countryServed) {
        this.code = code;
        this.message = message;
        this.countryServed = countryServed;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<CountryServed> getCountryServed() {
        return countryServed;
    }

}
