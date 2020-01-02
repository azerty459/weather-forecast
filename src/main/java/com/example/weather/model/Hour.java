package com.example.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hour {

    @JsonProperty("RH2m")
    private Integer humidity;
    @JsonProperty("CONDITION")
    private String condition;
    @JsonProperty("TMP2m")
    private Float temperature;
    @JsonProperty("APCPsfc")
    private Float precipitation;


    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Float precipitation) {
        this.precipitation = precipitation;
    }
}
