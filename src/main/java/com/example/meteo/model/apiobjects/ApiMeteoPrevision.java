package com.example.meteo.model.apiobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiMeteoPrevision {
    @JsonProperty("dt_txt")
    public String dateAsString;

    @JsonProperty("rain")
    public ApiRainProbability apiRainProbability;

    @JsonProperty("main")
    public ApiPrevisionMainContent apiPrevisionMainContent;

    @JsonProperty("weather")
    public List<ApiWeather> apiWeathers;
}
