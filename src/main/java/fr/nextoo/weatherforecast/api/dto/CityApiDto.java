package fr.nextoo.weatherforecast.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityApiDto {

    private String name;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
