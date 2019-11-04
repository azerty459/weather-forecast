package fr.nextoo.weatherforecast.service;

public interface HotestDayInWeekService<T>{

    public String getHotestDayInWeekByCity(String ville);
}