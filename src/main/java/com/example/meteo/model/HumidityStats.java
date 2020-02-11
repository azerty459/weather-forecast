package com.example.meteo.model;

public class HumidityStats {
    public double currentHumidity;
    public double meanHumidityForComingDays;
    public MeteoPrevision driestDayPrevision;

    public HumidityStats(double currentHumidity, double meanHumidityForComingDays, MeteoPrevision driestDayPrevision) {
        this.currentHumidity = currentHumidity;
        this.meanHumidityForComingDays = meanHumidityForComingDays;
        this.driestDayPrevision = driestDayPrevision;
    }
}
