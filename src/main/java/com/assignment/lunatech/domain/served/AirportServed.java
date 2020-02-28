package com.assignment.lunatech.domain.served;

public class AirportServed {

    private String id;
    private String name;
    private int runways;

    public AirportServed(String id, String name, int runways) {
        this.id = id;
        this.name = name;
        this.runways = runways;
    }

    public int getRunways() {
        return runways;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
