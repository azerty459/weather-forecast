package com.example.meteo.model.apiobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiPrevisionMainContent {
    @JsonProperty("temp")
    public double temperature;
    @JsonProperty("humidity")
    public int humidity;
}
