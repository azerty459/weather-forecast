package com.example.meteo.model;

import com.google.gson.JsonObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONObject;


public class MeteoInfo {

    public String date;
    public String description;
    public double temperature;
    public double humidity;


    public MeteoInfo(String dateAsString, String description, double temperature, double humidity) {
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
        this.date = dateAsString;
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

