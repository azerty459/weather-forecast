package com.example.meteo.model;

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

