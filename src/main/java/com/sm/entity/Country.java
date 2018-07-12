package com.sm.entity;

public class Country {
    private String country;

    private Double population;

    public Country(String country, Double population) {
        this.country = country;
        this.population = population;
    }

    public Country() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }
}