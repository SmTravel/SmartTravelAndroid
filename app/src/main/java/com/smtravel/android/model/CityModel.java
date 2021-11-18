package com.smtravel.android.model;

import com.google.gson.annotations.SerializedName;

public class CityModel {
    @SerializedName("id")
    private String ID;
    @SerializedName("name")
    private String name;
    @SerializedName("population")
    private String population;
    @SerializedName("region")
    private String region;

    public CityModel(String ID, String name, String population, String region) {
        this.ID = ID;
        this.name = name;
        this.population = population;
        this.region = region;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }
}
