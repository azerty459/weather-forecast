package com.example.meteo.model;

import com.example.meteo.model.apiobjects.ApiMeteoPrevision;
import com.example.meteo.model.apiobjects.ApiResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MeteoPrevision {

    public String date;
    public String description;
    public double temperature;
    public double humidity;


    public MeteoPrevision(String dateAsString, String description, double temperature, double humidity) {
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
        this.date = dateAsString;
    }

    public MeteoPrevision(ApiMeteoPrevision apiMeteoPrevision) {
        this.description = apiMeteoPrevision.apiWeathers.get(0).description;
        this.temperature = apiMeteoPrevision.apiPrevisionMainContent.temperature;
        this.humidity = apiMeteoPrevision.apiPrevisionMainContent.humidity;
        this.date = apiMeteoPrevision.dateAsString;
    }

    static public List<MeteoPrevision> meteoPrevisionsFrom(ApiResponse apiResponse) {
        if (apiResponse==null || apiResponse.apiMeteoPrevisions==null) {
            return Collections.emptyList();
        }
        return apiResponse.apiMeteoPrevisions.stream()
                .map(aMP -> new MeteoPrevision(aMP))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MeteoInfo{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}

