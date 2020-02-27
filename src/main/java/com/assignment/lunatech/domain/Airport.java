package com.assignment.lunatech.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {

    private String ident;
    private String name;
    private String[] runways;
    private int runwaysCount;

    public String getIdent() {
        return ident;
    }

    public String getName() {
        return name;
    }

    public String[] getRunways() {
        return runways;
    }

    public int getRunwaysCount() {
        int count = 0;
        for(String runway : runways) {
            count++;
        }
        return count;
    }

    public String airportsToString(Airport[] airports) {
        String list = "";
        for(Airport air : airports){
            list += air.getName() + " \n";
        }
        return list;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", ident: " + getIdent();
    }
}
