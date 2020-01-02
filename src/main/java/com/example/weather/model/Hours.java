package com.example.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hours {

    @JsonProperty("0H00")
    private Hour hour0;

    public Hour getHour0() {
        return hour0;
    }

    public void setHour0(Hour hour0) {
        this.hour0 = hour0;
    }
}
