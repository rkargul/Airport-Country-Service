package com.assignment.lunatech.domain;

public class Runway {
    private String airport_ident;

    public Runway() {
    }

    public Runway(String airport_ident) {
        this.airport_ident = airport_ident;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public void setAirport_ident(String airport_ident) {
        this.airport_ident = airport_ident;
    }
}
