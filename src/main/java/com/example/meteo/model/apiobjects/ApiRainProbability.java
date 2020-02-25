package com.example.meteo.model.apiobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiRainProbability {
    @JsonProperty("3h")
    public double probaOfRainWithinThreeHour;
}
